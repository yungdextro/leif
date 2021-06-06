class Rock {

  PVector position;
  PImage rockImage;

  Rock(float x,float y, PImage _rockImage) {
    position = new PVector(x,y);
    rockImage = _rockImage;
  }

  void display() {
    pushMatrix();
    translate(position.x, position.y);
    image(rockImage, -rockImage.width/2, -rockImage.height/2);
    popMatrix();
  }

  void update() {      // körs varje frame
    display();
  }
}
