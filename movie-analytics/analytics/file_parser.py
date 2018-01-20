import os
import sys
import fileinput
import re

'''
This module parses comments taken from bookmyshow.
Also, this parser does not remove all the emojis. So, delete the erroring emojis manually from clean files.
'''


def ls(dir, hidden=False, relative=True):
    nodes = []
    for nm in os.listdir(dir):
        if not hidden and nm.startswith('.'):
            continue
        if not relative:
            nm = os.path.join(dir, nm)
        nodes.append(nm)
    nodes.sort()
    return nodes


def find(root, files=True, dirs=False, hidden=False, relative=True, topdown=True):
    root = os.path.join(root, '')  # add slash if not there
    for parent, ldirs, lfiles in os.walk(root, topdown=topdown):
        if relative:
            parent = parent[len(root):]
        if dirs and parent:
            yield os.path.join(parent, '')
        if not hidden:
            lfiles   = [nm for nm in lfiles if not nm.startswith('.')]
            ldirs[:] = [nm for nm in ldirs  if not nm.startswith('.')]  # in place
        if files:
            lfiles.sort()
            for nm in lfiles:
                nm = os.path.join(parent, nm)
                yield nm


def test(root):
    ls(root, hidden=True)
    file_names_list = []
    for f in find(root, dirs=True):
        file_names_list.append(root + "/" + f)
    #print 'file_names_list in dir_path: ', file_names_list
    return file_names_list


def get_path_of_folder_having_input_review_files():
    dir_path = os.path.dirname(os.path.realpath(__file__))
    dir_path = os.path.abspath(os.path.join(dir_path, os.pardir))
    dir_path = dir_path + "/input_review_file"
    #print 'dir_path: ', dir_path
    return dir_path


def get_cleanup_filename(file):
    file_name_split = file.split('/')
    file_name = file_name_split[len(file_name_split)-1]
    file_number = re.findall('\d', file_name)
    return re.sub('\d.txt', file_number[0]+'_clean.txt', file)




def clean_special_chars_from_line(line):
    if line.__contains__('Verified Review') or is_line_having_dd_mm_yy(line):
        return ''
    return line


def cleanup_file(file):
    print 'working on file: ', file
    file_clean_name = get_cleanup_filename(file)
    print 'file_clean_name', file_clean_name
    if os.path.exists(file_clean_name): os.remove(file_clean_name)
    clean_file = open(file_clean_name, "a")  # open for append
    flag = False
    skip_next_line = False
    for line in open(file):
        line = clean_special_chars_from_line(line)
        if line.__contains__('\n') and len(line) == 1:
            flag = True
            skip_next_line = True
        if flag and skip_next_line:
            clean_file.write(line.rstrip('\n'))
            flag = False
        elif skip_next_line:
            skip_next_line = False
        else:
            clean_file.write(line)
    clean_file.close()


def replace_words(base_text, device_values):
    return base_text+"test"


def is_line_having_dd_mm_yy(line):
    re1 = '((?:(?:[0-2]?\\d{1})|(?:[3][01]{1}))[-:\\/.](?:[0]?[1-9]|[1][012])[-:\\/.](?:(?:\\d{1}\\d{1})))(?![\\d])'  # DDMMYY 1
    rg = re.compile(re1, re.IGNORECASE | re.DOTALL)
    m = bool(rg.search(line))
    return m


if __name__ == "__main__":
    dir_path = get_path_of_folder_having_input_review_files()
    file_names_list = test(dir_path)
    for file in file_names_list:
        if not file.__contains__('clean'):
            cleanup_file(file)
    print 'done !'
