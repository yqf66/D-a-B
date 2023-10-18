import os
import mysql.connector

# 建立数据库连接
connection = mysql.connector.connect(
    host="LAPTOP-R6722664",
    user="root",
    password="lyj@83231336",
    database="your_database"
)

# 指定存放图像的文件夹路径
folder_path = r"E:\BaiduNetdiskDownload\Car\Software\CWIFIpc\Picture"

# 获取文件夹中图像文件的列表
image_files = os.listdir(folder_path)

# 遍历每个图像文件
for image_file_name in image_files:
    # 创建完整的文件路径
    image_file_path = os.path.join(folder_path, image_file_name)

    # 读取图像文件
    with open(image_file_path, "rb") as image_file:
        image_data = image_file.read()

    # 插入图像数据
    cursor = connection.cursor()
    insert_query = "INSERT INTO images (image_data) VALUES (%s)"
    cursor.execute(insert_query, (image_data,))
    connection.commit()

    # 关闭游标
    cursor.close()

# 关闭连接
connection.close()