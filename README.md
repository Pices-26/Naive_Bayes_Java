CA Question:
5. Machine learning model, using Naïve Bayes
This assignment allows you to learn about machine learning, including building a predictive/classification model.
Background: Machine learning is a huge component of Artificial Intelligence. It allows computers to
perform tasks automatically, using algorithms to spot patterns (very similar to how humans do). A
typical use of machine learning is to build classification models – which classify or predict what an
input is about. For example, machine learning models can be created that are “trained” to a
recognise a fraudulent insurance claim. This is done often done by looking at past examples
insurance claims that were fraudulent and claims that weren’t fraudulent – and spotting the
patterns associated with each. This is an example of “supervised learning” - where you allow a
computer to learn from examples – and it’s very similar to how we learn as humans. We “train” a
machine learning algorithm with examples (e.g. 100 “good” insurance claims, and 100 “fraudulent”
claims). The algorithm figures out the patterns – and is able to then classify or predict whether a
new claim is fraudulent or not, having sussed out the pattern.
This assignment will use a popular machine learning algorithm called Naïve Bayes – to be
explained in class. A simple dataset is provided below showing previous cases of whether patients
had tonsillitis or not (based on assessing temperature, aches and pains and sore throat). Using java,
the assignment should “train” a model using the dataset provided. Don’t hard code the classifier in
anyway – make sure it is driven by the data dynamically in your code. Using a GUI, allow for patient
symptoms to be put entered in, and the prediction model will give the probability of whether they
have tonsillitis or not.
To make this work well , you will need to have a GUI to take the new input (patient systems) that
you want to test whether likely leading to tonsillitis or not.

• Have the application read in the training set and do the training dynamically (i.e. don’t hard
code the rules for the classifier).

• If extra data rows, termed “instances” are added to the dataset, your classifier should still work
(in fast, improved as a result of new data).

• Allow for model to train on some of the dataset (e.g. 70%) and test itself on the remainder of
the dataset(30%) so that it knows how “good” it is (i.e. be able to evaluate itself). 
