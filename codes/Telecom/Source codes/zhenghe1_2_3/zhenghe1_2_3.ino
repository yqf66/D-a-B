#include <Servo.h>
#include <IRremote.h>
volatile int i;
void goAhead() {
  analogWrite(5,150);
  digitalWrite(7,HIGH);
  analogWrite(6,150);
  digitalWrite(4,HIGH);
  Serial.print("goAhead");
}

void Left() {
  analogWrite(5,150);
  digitalWrite(7,LOW);
  analogWrite(6,120);
  digitalWrite(4,HIGH);
  Serial.print("goLeft");
}

void stop() {
  analogWrite(5,0);
  digitalWrite(7,HIGH);
  analogWrite(6,0);
  digitalWrite(4,HIGH);
  Serial.print("stop");
}

void goBack() {
  analogWrite(5,150);
  digitalWrite(7,LOW);
  analogWrite(6,150);
  digitalWrite(4,LOW);
  Serial.print("goBack");
}

void Right() {
  analogWrite(5,120);
  digitalWrite(7,HIGH);
  analogWrite(6,150);
  digitalWrite(4,LOW);
  Serial.print("goRight");
}

Servo servo_10;
Servo servo_9;
int RECV_PIN = 40;
IRrecv irrecv(RECV_PIN);
decode_results results;
unsigned long IRforward = 0xFF18E7;
unsigned long IRbackward = 0xFF4AB5;
unsigned long IRleft = 0xFF10EF;
unsigned long IRright = 0xFF5AA5;
unsigned long IRswitch = 0xFF38C7;
float checkdistance_A2_A3() {
  digitalWrite(A2, LOW);
  delayMicroseconds(2);
  digitalWrite(A2, HIGH);
  delayMicroseconds(10);
  digitalWrite(A2, LOW);
  float distance = pulseIn(A3, HIGH) / 58.00;
  delay(10);
  return distance;
}
void autoa()
{
   Serial.println(checkdistance_A2_A3());
  if (checkdistance_A2_A3() > 25) {
    goAhead();

  }
  if (checkdistance_A2_A3() < 24) {
    Left();
    delay(300);
    stop();
    delay(50);

  }
  if (digitalRead(A4) == 0 && digitalRead(A5) == 1) {
    Right();
    delay(500);

  }
  if (digitalRead(A4) == 1 && digitalRead(A5) == 0) {
    Left();
    delay(500);

  }
  if (checkdistance_A2_A3() < 8 && digitalRead(A4) == 0) {
    Right();
    delay(300);
    stop();
    delay(50);

  }
  if (checkdistance_A2_A3() < 8 && digitalRead(A5) == 0) {
    Left();
    delay(300);
    stop();
    delay(50);

  }
  //if (checkdistance_A2_A3() < 15 && (digitalRead(A5) == 0 && digitalRead(A4) == 0)) {
    //stop();
    //delay(50);
    //goBack();
    //delay(1000);
    //Left();
    //delay(800);

  //}
}
void hw()
{
  for(int p=0;p<100;p++)
      {
      if (digitalRead(A4) == 1 && digitalRead(A5) == 1) 
       stop();
      if (digitalRead(A4) == 0 && digitalRead(A5) == 1) 
       Left();
      if (digitalRead(A4) == 1 && digitalRead(A5) == 0) 
       Right();
      while (digitalRead(A4) == 0 && digitalRead(A5) == 0) 
       goAhead();  
      }
}
void auto_operate()
{
  for(int j=0;j<30;j++)
     {
      autoa();
     }
}
void setup(){
  pinMode(7, OUTPUT);
  pinMode(4, OUTPUT);
  servo_9.attach(9);
  pinMode(A2, OUTPUT);
  pinMode(A3, INPUT);
  i=0;
  Serial.begin(9600);
  irrecv.enableIRIn();
  pinMode(A4, INPUT);
  pinMode(A5, INPUT);
  servo_9.write(90);
  
}

void loop(){
  //servo_9.write(10);
  //servo_10.write(90);
  delay(0);
  if (Serial.available() > 0) {
    i = Serial.read();
    switch (i) {
     case 01:
      servo_9.write(90);
      delay(0);
      goAhead();
      digitalWrite(11,HIGH);
      break;
     case 02:
      goBack();
      digitalWrite(12,HIGH);
      break;
     case 03:
      digitalWrite(13,HIGH);
      Left();
      break;
     case 04:
      Right();
      break;
     case 00:
      stop();
      digitalWrite(11,LOW);
      digitalWrite(12,LOW);
      digitalWrite(13,LOW);
      break;
     case 05:
      servo_9.write(130);
      delay(0);
      break;
     case 06:
      servo_9.write(50);
      delay(0);
      break;
     case 07:
     auto_operate();
      break;
      case B0100001:
       hw();
       break;
    }
  }

  if (irrecv.decode(&results))
    {
      if(results.value == IRforward){
        goAhead();
        }
      else if(results.value == IRbackward){
        goBack();
        }
      else if(results.value == IRleft){
        Left();
        }
      else if(results.value == IRright){
        Right();
        }
      else if(results.value == IRswitch){
        stop();
        }
      else{
        Serial.println("G");
        }
      irrecv.resume();
    }
  
}
