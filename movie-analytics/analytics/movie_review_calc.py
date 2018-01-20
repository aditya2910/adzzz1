import pickle
from nltk.tokenize import word_tokenize
from nltk.corpus import stopwords
import re

class ReviewCalc:

    POSITIVE = "POSITIVE"
    NEGATIVE = "NEGATIVE"

    @staticmethod
    def get_positive_review_percentage():
        total_no_of_reviews = 0
        positive_count = 0
        negative_count = 0
        # no special chars are allowed
        with open("/Users/adityakumar/Desktop/adi/my-git/adzzz1/movie-analytics/input_review_file/movie_reviews_1_clean.txt") as f:
            total_no_of_reviews = total_no_of_reviews + 1
            for line in f:
                line = remove_emojis_from_line(line)
                print 'line:', line
                resp = get_suggestion_for_given_review(line)
                if resp is "POSITIVE":
                    positive_count = positive_count + 1
                else:
                    negative_count = negative_count + 1
        print (total_no_of_reviews, positive_count, negative_count)


def remove_emojis_from_line(line):
    try:
        # UCS-4
        patt = re.compile(u'([\U00002600-\U000027BF])|([\U0001f300-\U0001f64F])|([\U0001f680-\U0001f6FF])')
    except re.error:
        # UCS-2
        patt = re.compile(
            u'([\u2600-\u27BF])|([\uD83C][\uDF00-\uDFFF])|([\uD83D][\uDC00-\uDE4F])|([\uD83D][\uDE80-\uDEFF])')
    return patt.sub('', line)


def get_suggestion_for_given_review(review):
    classifier = load_classifier()
    words = word_tokenize(review)
    words = create_word_features(words)
    print classifier.classify(words)
    return classifier.classify(words)

def load_classifier():
    f = open('semtiment_classifier.pickle', 'rb')
    classifier = pickle.load(f)
    f.close()
    return classifier

def create_word_features(words):
    words = [i.decode('UTF-8') if isinstance(i, basestring) else i for i in words]
    useful_words = [word for word in words if word not in stopwords.words("english")]
    my_dict = dict([(word, True) for word in useful_words])
    return my_dict



