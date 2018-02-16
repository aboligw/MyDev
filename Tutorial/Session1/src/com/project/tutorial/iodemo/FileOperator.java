package com.project.tutorial.iodemo;

import static com.project.tutorial.common.MyScanner.display;
import static com.project.tutorial.common.MyScanner.getInt;
import static com.project.tutorial.common.MyScanner.getString;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperator {
    public FileOperator() {
        super();
    }

    public static void main(String[] args) {
        String con = "Y";
        while ("Y".equalsIgnoreCase(con)) {
            int choice = menu();
            switch (choice) {
            case 1:
                //make directory
                File dir = getDir();
                if (dir.exists()) {
                    display("Directory with this name exists already");
                }
                if (dir.mkdirs())
                    display("Done!!!!!");
                else
                    display("PRoblem***");
                break;
            case 2:
                //recursive delete
                dir = getDir();
                remDir(dir);
                break;
            case 3:
                dir = getDir();
                display("Enter new name");
                File newf = new File(dir.getParent() + "\\" + getString());
                dir.renameTo(newf);
                break;
            case 4:
                //not working
                dir = getDir();
                display("Enter copy destination directory");
                File dest = new File(getString());
                copyF(dir, dest);
                break;
            case 5:
                //Display persmissions on a directory and set it to read only;
                dir = getDir();
                try {
                    dir.createNewFile();
                } catch (IOException e) {
                }
                display("Directory can read?" + dir.canRead());
                display("Directory can write?" + dir.canWrite());
                display("Directory can Execute?" + dir.canExecute());
                display("" + dir.setReadable(false) + //(false);
                        dir.setWritable(false) + dir.setExecutable(false));
                display("=========After set=======");
                display("Directory can read?" + dir.canRead());
                display("Directory can write?" + dir.canWrite());
                display("Directory can Execute?" + dir.canExecute());

                try {
                    System.out.println(dir.getCanonicalPath());
                } catch (IOException e) {
                }
                System.out.println(dir.delete());


                break;
            }
            display("Do you want to continue?" + "\\");
            con = getString();
        }
    }

    public static File getDir() {
        display("Enter directory name");
        File dir = new File(getString());

        return dir;
    }

    public static int menu() {
        display("-----------------MENU-----------------");
        display("1.Make directory");
        display("2.Delete directory");
        display("3.Rename");
        display("Copy Directory");
        display("Enter your choice");
        int n = getInt();
        return n;
    }

    private static void remDir(File dir) {
        System.out.println(dir);
        if (dir.isDirectory()) {
            File[] list = dir.listFiles();
            //File f=new File(list[0]);
            for (File f : list) {
                if (f.isDirectory() && f.listFiles().length != 0) {
                    remDir(f);
                }
                f.delete();
            }
            dir.delete();
        }
    }

    private static void copyF(File dir, File dest) {
        display("Dir: " + dir);
        display("Dest: " + dest);
        if (dir.isDirectory() && !dest.exists()) {
            dest.mkdir();
        }
        if (dir.isDirectory()) {
            String[] list = dir.list();
            for (String f : list) {
                File srcFile = new File(dir, f);
                File destFile = new File(dest, f);
                copyF(srcFile, destFile);
            }
        } else {
            FileInputStream in = null;
            FileOutputStream out = null;

            try {
                in = new FileInputStream(dir);
                out = new FileOutputStream(dest);

                byte[] buffer = new byte[1024];

                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
            } catch (Exception e) {
                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                try {
                    out.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }


}


