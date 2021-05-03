Lander theEagle;
Leif theLeif;

int state = 0;

PImage theEagleImage, skyImage, theLeifImage, FlameImage, theLeifGameOverImage, theLeifGameOverImage2;

float gravity = 0.003;

void setup() {

  size(800, 600);

  theEagleImage = loadImage("bilder/theEagle.png");
  theLeifImage = loadImage("bilder/leif in an alien saucer 1.png");
  skyImage = loadImage("bilder/himlen2.png");
  FlameImage = loadImage("bilder/Flame.png");
  theLeifGameOverImage = loadImage("bilder/big leif-1.png");
  theLeifGameOverImage2 = loadImage("bilder/big leif-2.png");

  theEagle = new Lander();
  theLeif = new Leif();
}

void draw() {
  image(skyImage, 0, 0);

  theEagle.update();
  theLeif.update();

  // collisionCheck();

  if (state == 1) {
    pushMatrix();
    translate(width/2, height/2);
    image(theLeifGameOverImage, 0, 0);
    popMatrix();
  }
}
