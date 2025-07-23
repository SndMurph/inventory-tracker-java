@echo off
cd /d C:\Users\sndmu\Desktop\Workspace\InventoryManage

echo Compiling Java files...
javac -cp .;mysql-connector-j-9.3.0.jar inventorymanage\*.java

echo Running InventoryApp...
java -cp .;mysql-connector-j-9.3.0.jar inventorymanage.InventoryApp

pause