import os
import sys

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


def cleanup_file(file):
    print 'working on file: ', file
    with open(file, 'r+') as f:
        lines = f.readlines()
        #f.seek(0)
        #f.truncate()
        for line in lines:
            print line
            if 'a"' in line:
                print line
        f.write(line)


if __name__ == "__main__":
    dir_path = get_path_of_folder_having_input_review_files()
    file_names_list = test(dir_path)
    for file in file_names_list:
        cleanup_file(file)
    print 'done !'
