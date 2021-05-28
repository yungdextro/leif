void collisionCheck() {

  if (theEagle.position.dist(theLeif.position) < 40) {
    state = 2;
  }

  if (theEagle.position.y > height - theEagleImage.height) {
    state = 3;
  }
}


boolean checkCollisionRocks() {
  
  PVector theEagleLandingPos = new PVector(theEagle.position.x + theEagleImage.width / 2, theEagle.position.y + theEagleImage.height);
  for (int i = 0; i < numRocks; i++) {
    if (theEagleLandingPos.dist(rocks[i].position) < 30) {
      return true;
    }
  }
  return false;
}
