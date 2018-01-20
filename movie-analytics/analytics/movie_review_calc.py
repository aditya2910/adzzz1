import pickle
from nltk.tokenize import word_tokenize
from nltk.corpus import stopwords

class ReviewCalc:

    POSITIVE = "POSITIVE"
    NEGATIVE = "NEGATIVE"

    @staticmethod
    def get_positive_review_percentage():
        total_no_of_reviews = 0
        positive_count = 0
        negative_count = 0
        # no special chars are allowed
        with open("Output.txt") as f:
            total_no_of_reviews = total_no_of_reviews + 1
            for line in f:
                resp = get_suggestion_for_given_review(line)
                if resp is "POSITIVE":
                    positive_count = positive_count + 1
                else:
                    print line
                    negative_count = negative_count + 1
        print (total_no_of_reviews, positive_count, negative_count)



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
    useful_words = [word for word in words if word not in stopwords.words("english")]
    my_dict = dict([(word, True) for word in useful_words])
    return my_dict



