# Yourpinions
A simple Android app designed to let users express their opinions while other users judge your deepest thoughts with their votes. This project is carried out for Boost Malaysia's interview coding challenge.

![](H1NRb3tq0F3eIkRc6f.gif)

## Features
* Displays top 20 Yourpinions on the main page.
* Add a Yourpinion that is up to 255 characters long.
* Upvote and downvote Yourpinions.

## Current Technical Features
* Uses Android Architecture Components to implement the MVVM pattern.
* Uses Firebase Realtime Data to store and retrieve Yourpinions in the repository.
* The ViewModel retrieves a LiveData<ArrayList<Yourpinion>> object from the repository which then allows the fragment to observe and dynamically refresh a RecyclerView on the main page. This allows the data to live in the process, respect Android lifecycles and does not require data persistence.
* 
  
## Future Work
* Using transactions to update Firebase Realtime Data to avoid vote count miscalculations when multiple users vote at the same time.
* Fix Mockito inline to allow for Android UI Tests.
* 
