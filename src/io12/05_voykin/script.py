import sys
import os
import shutil

if __name__ == "__main__":
    os.chdir(sys.path[0])
    class_names_list = [f"Lab{i}.java" for i in range(1, 9)]
    for i in class_names_list:
        try:
            shutil.copy(
                os.path.abspath(f"java_oop_lab\\src\\{i}"),
                sys.path[0])
        except FileNotFoundError:
            print(f"File {i} not found")