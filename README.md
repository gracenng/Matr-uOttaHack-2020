Matr is Latin for mother. We aim to support social workers in managing the foster care system.

![Screenshot_1590152334](https://user-images.githubusercontent.com/42276283/82670331-ef807280-9c0a-11ea-9adc-b254ddced200.png =853x480)
<a href="url"><img src="(https://user-images.githubusercontent.com/42276283/82670331-ef807280-9c0a-11ea-9adc-b254ddced200.png" align="left" height="853" width="480" ></a>
![Screenshot_1590152350](https://user-images.githubusercontent.com/42276283/82670336-f14a3600-9c0a-11ea-98af-181cb67f9f06.png)
![Screenshot_1590152387](https://user-images.githubusercontent.com/42276283/82670340-f27b6300-9c0a-11ea-8354-e376cc262248.png)


Matr as a product is broken down into a suite of tools and features. These include an emotional diary application for the foster children themselves and a database display webapp for the parents and caseworkers, supported by a wide variety of under-the-hood technologies, such as MQTT/Solace, NLP/ Sentiment Analysis and Google Cloud. Upon launching the Android application, the foster child is prompted to enter their credentials (which would be in the form of a code word between the caseworker and the foster child). They would then be asked a series of questions relating to how their week has gone on a wide variety of topics to gauge how welcoming and accommodating their home environment has been. This form of analysis is instrumental in determining how the childrens’ mental health has been impacted by external factors in their lives. 

Their data is then sent to the front-end web app, which utilizes the “emotional scores” that the NLP component of the Android application determined to show an icon beside each child in a table-setup in the caseworker’s app page, which reflects their emotional states (angry face, to signify extremely dissatisfied, to very happy face, which signifies extremely satisfied). We decided to focus on this specific pain point, as it is very difficult for an individual case worker to manage and remember the emotional states of every single one of their foster children, meaning that a visual and straight-forward dashboard with real-time updates of their children’s states is imperative in ensuring that every child’s needs are accounted for. We used a 5-point Likert scale, having each face represent 2 points on the sentiment analysis scoring system. This was done to minimize confusion when caseworkers/parents are tracking the children’s emotional responses to their current accommodations. The webapp is secure, with basic authentication in the form of a username and password login page, and includes other features such as a persona-based profile of a specific child as the foster parents’ page and an instruction page to speed up the process for first-time users.
