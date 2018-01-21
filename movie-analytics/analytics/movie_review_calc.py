import pickle
from nltk.tokenize import word_tokenize
from nltk.corpus import stopwords
import re


class ReviewCalc:

    @staticmethod
    def get_positive_review_percentage(cleaned_review_file):
        total_no_of_reviews = 0
        positive_count = 0
        negative_count = 0
        positive = 'positive'
        # no special chars are allowed from cleaned files, especially emojis
        with open(cleaned_review_file) as f:
            print 'hello total'
            for line in f:
                total_no_of_reviews = total_no_of_reviews + 1
                line = remove_emojis_from_line(line)
                print 'line:', line
                resp = get_suggestion_for_given_review(line)
                if resp == positive:
                    positive_count = positive_count + 1
                else:
                    negative_count = negative_count + 1
        print (total_no_of_reviews, positive_count, negative_count)
        return calculate_percent(total_no_of_reviews, positive_count)


def calculate_percent(total_no_of_reviews, positive_count):
    return (positive_count*100)/total_no_of_reviews


def remove_emojis_from_line(line):
    try:
        # UCS-4
        patt = re.compile(u'([\U00002600-\U000027BF])|([\U0001f300-\U0001f64F])|([\U0001f680-\U0001f6FF])')
    except re.error:
        # UCS-2
        patt = re.compile(u'([\u2600-\u27BF])|([\uD83C][\uDF00-\uDFFF])|([\uD83D][\uDC00-\uDE4F])|([\uD83D][\uDE80-\uDEFF])')
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
