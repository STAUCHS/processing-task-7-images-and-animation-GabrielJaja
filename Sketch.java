import processing.core.PApplet;
import processing.core.PImage;


public class Sketch extends PApplet {
  // Declaring Images
    PImage imgRace;
    PImage imgFrog;
    PImage imgFrogbackground;
  // Declaring Velocity variables
    float XRacePos = 200;
    float YRacePos = 200;
    float XvelRace = 3;
    float YvelRace = 1;
    float fltAngles = 1;
 
  // Ellipse Position
    float fltEllipseX = 30;
    float fltEllipseY = 10;

  public void settings() {
    size(600, 425);
  }

  public void setup() {
  // Loading image files
    imgFrog = loadImage("frogimage.png");
    imgFrogbackground = loadImage("frogimagebackground.jpg");

     // Resizing the object
    imgFrog.resize(imgFrog.width / 8, imgFrog.height / 8);  
  }

  public void draw() {
    image(imgFrogbackground, 0, 0);
  // Draw image and move
    image(imgFrog, XRacePos, YRacePos);

  // Along the x-axis
    XRacePos  += XvelRace;
    if (XRacePos < 0 || XRacePos > width - imgFrog.width) {
      XvelRace *= -1;
      fltAngles *= -1;
    }
    else {
    XvelRace = sin(XvelRace += fltAngles);
    }
  // Along y-axis
    YRacePos = YRacePos + YvelRace;
    if (YRacePos < 0 || YRacePos > height - imgFrog.height) {
      YvelRace *= -1;
    }
    else {
    YvelRace = (YvelRace += 1);
    }
  // Shape to animate
    ellipse(20, fltEllipseX, 33, 30);
   
    fill(fltEllipseX += 5);
   
    fltEllipseX = fltEllipseX + 1;
    fltEllipseY = fltEllipseY - 1;

    if (fltEllipseX > width) {
      fltEllipseX = 0;
      fltAngles += 0.01;
    }
    else {
      fltEllipseY += 1;
    }
  }
}