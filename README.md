# Botany

Botany is a hub repository for all the Clojure-language Twitter bots I run. Currently, these bots include:

* [@EX_BAD_EBOOKS](https://twitter.com/EX_BAD_EBOOKS) – generates and tweets cryptic error messages
* [@bot_mccloud](https://twitter.com/bot_mccloud) – tweets random panels from Scott McCloud's *[Understanding Comics](http://scottmccloud.com/2-print/1-uc/)*

I used to maintain some of these as separate repositories, but [Heroku](https://www.heroku.com) (on which I host almost all of my bots) only allows you to have up to five separate "apps" at a time for free. Fortunately for me, nothing really prevents me from running multiple bots out of a single repository (and thus a single Heroku app), so here we are!

(Using a single repo also makes it slightly easier to share code between some of the bots and ensure that all of them stay up to date with any fixes or improvements I implement – something which has become a bigger issue for me as time goes on.)
