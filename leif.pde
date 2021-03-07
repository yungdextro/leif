Lander theEagle;


PImage theEagleImage, skyImage, theLeifImage;

float gravity = 0;

void setup() {

  size(800, 600);

  theEagleImage = loadImage("theEagle.png");
  theLeifImage = loadImage("leif in an alien saucer 1.png");
  skyImage = loadImage("himlen2.png");

  theEagle = new Lander();
}

void draw() {
  image(skyImage, 0, 0);

  theEagle.update();
}
