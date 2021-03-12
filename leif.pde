Lander theEagle;
Leif theLeif;

PImage theEagleImage, skyImage, theLeifImage;

float gravity = 0;

void setup() {

  size(800, 600);

  theEagleImage = loadImage("bilder/theEagle.png");
  theLeifImage = loadImage("bilder/leif in an alien saucer 1.png");
  skyImage = loadImage("bilder/himlen2.png");

  theEagle = new Lander();
  theLeif = new Leif();
}

void draw() {
  image(skyImage, 0, 0);

  theEagle.update();
  theLeif.update();
}
