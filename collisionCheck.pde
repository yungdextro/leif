void collisionCheck() {

  if (theEagle.position.dist(theLeif.position) < 40){
   state = 2;
  }
  
  if (theEagle.position.y > height - theEagleImage.height){
    state = 3;
  }
  
}
