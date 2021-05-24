void collisionCheck() {

  if (theEagle.position.dist(theLeif.position) < 40) {
    state = 2;
  }

  if (theEagle.position.y > height - theEagleImage.height) {
    state = 3;
  }
}


boolean checkCollisionRocks() {
  for (int i = 0; i < numRocks; i++) {
    PVector theEagleLandingPos = new PVector(theEagle.position.x, theEagle.position.y + theEagleImage.height);
    if (theEagleLandingPos.dist(rocks[i].position) < 30) {
      return true;
    }
  }
  return false;
}
