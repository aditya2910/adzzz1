import nltk.classify.util
import pickle
from nltk.classify import NaiveBayesClassifier
from nltk.corpus import movie_reviews
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
from nltk.corpus import wordnet

# This is how the Naive Bayes classifier expects the input
def create_word_features(words):
    useful_words = [word for word in words if word not in stopwords.words("english")]
    my_dict = dict([(word, True) for word in useful_words])
    return my_dict

def train_data_and_save_classifier(mood):
    mood_hyponyms = get_hypynyms_of_list(mood)
    print mood_hyponyms

    pos_reviews = []
    for fileid in movie_reviews.fileids('pos'):
        words = movie_reviews.words(fileid)
        pos_reviews.append((create_word_features(words), "positive"))
    print "pos reviews"
    print pos_reviews[:5]
    pos_reviews = mood_hyponyms + pos_reviews
    print(len(pos_reviews))
    neg_reviews = []
    for fileid in movie_reviews.fileids('neg'):
        words = movie_reviews.words(fileid)
        neg_reviews.append((create_word_features(words), "negative"))
    print(len(neg_reviews))

    train_set = neg_reviews[250:] + pos_reviews[250:]
    test_set = neg_reviews[:250] + pos_reviews[:250]
    print(len(train_set), len(test_set))

    classifier = NaiveBayesClassifier.train(train_set)
    f = open('semtiment_classifier.pickle', 'w+')
    pickle.dump(classifier, f, -1)
    f.close()

    accuracy = nltk.classify.util.accuracy(classifier, test_set)
    print(accuracy * 100)

def load_classifier():
    f = open('semtiment_classifier.pickle', 'rb')
    classifier = pickle.load(f)
    f.close()
    return classifier



def get_suggestion_for_given_review(review):
    classifier = load_classifier()
    words = word_tokenize(review)
    words = create_word_features(words)
    print classifier.classify(words)


def get_hypynyms_of_list(mood):
    syn = wordnet.synsets(mood)[0]
    mood_hyponyms = syn.hyponyms()

    mood_hyponyms_words = []
    for content in mood_hyponyms:
        content = str(content)
        mood_hyponyms_words.append(find_between_r(content, "('", ".n."))
    return mood_hyponyms_words

def find_between_r( s, first, last ):
    try:
        start = s.rindex( first ) + len( first )
        end = s.rindex( last, start )
        return s[start:end]
    except ValueError:
        return ""


if __name__ == "__main__":
    print 'train_data_and_save_classifier'
    train_data_and_save_classifier("action")
    #review = "Boring, predictable and a lot fictional. in one scene, there are 20 + men firing at Salman and non of the bullets hit or get even close to him. ohh plz"
    #get_suggestion_for_given_review(review)
    print 'done !'


