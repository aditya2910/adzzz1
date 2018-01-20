import sys

def main():
    print "clean the file"
    with open("Output.txt", "w") as text_file:
        with open("movie_reviews.txt") as f:
            for line in f:
                if not line.isspace():
                    sys.stdout.write(line)
                    text_file.write(line)

if __name__ == "__main__":
    main()
    print 'done !'
