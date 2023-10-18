

from ultralytics import YOLO
import cv2

model = YOLO("best09.pt")
# 指定存放图像的文件夹路径
folder_path = "./Picture/"

 #save detection results *
results = model.predict(folder_path,save=True,save_txt=True,lasses=[0,1,2],conf=0.5)