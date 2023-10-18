from ultralytics import YOLO

model = YOLO('last.pt')

model.train(
  data = './datasets/demo/data.yaml',
  epochs = 50,
  imgsz = 640
)
