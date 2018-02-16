package com.project.tutorial.iodemo;

import static com.project.tutorial.common.MyScanner.display;
import static com.project.tutorial.common.MyScanner.getInt;
import static com.project.tutorial.common.MyScanner.getString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFileOper {
    public TextFileOper() {
        super();
    }

    public static void main(String[] args) {
        String con = "Y";
        while ("Y".equalsIgnoreCase(con)) {
            int choice = menu();
            switch (choice) {
            case 1:
                //read and print on console
                File myFile = getFile();
                readPrint(myFile);
                break;
            case 2:
                //write to file and print
                File myfile1 = getFile();
                printWrite(myfile1);
                break;
            case 3:
                //text count.
                File myf = getFile();
                if (myf.exists()) {
                    wordCtr(myf);
                } else {
                    display("no such file exists");
                }
                break;
            case 4:
                //Replace text
                File myF = getFile();
                if (myF.exists()) {
                    wordReplace(myF);
                } else {
                    display("no such file exists");
                }
                break;
            case 5:
                //Change case
                File src = getFile();
                if (src.exists()) {
                    changeCase(src);
                } else {
                    display("no such file exists");
                }
                break;

            }
            display("Do you want to continue?" + "\\");
            con = getString();

        }
    }

    private static void readPrint(File myFile) {
        if (myFile.exists()) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(myFile));
                String contentLine = br.readLine();
                while (contentLine != null) {
                    System.out.println(contentLine);
                    contentLine = br.readLine();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } finally {
                try {
                    if (br != null)
                        br.close();
                } catch (IOException ioe) {
                    System.out.println("Error in closing the BufferedReader");
                }
            }
        } else {
            display("This document does not exist");
        }
    }

    public static File getFile() {
        display("Enter text document name");
        File dir = new File(getString());
        return dir;
    }

    public static int menu() {
        display("-----------------MENU-----------------");
        display("1.Read-and print text doc");
        display("2.Print and write text doc");
        display("3.Search String n display count");
        display("Copy Directory");
        display("Enter your choice");
        int n = getInt();
        return n;
    }

    private static void printWrite(File myFile) {
        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
            } catch (IOException e) {
                display("File Creation unsuccessful");
            }
        }
        BufferedWriter br = null;
        try {
            br = new BufferedWriter(new FileWriter(myFile));
            String cont = "Y";
            while ("Y".equalsIgnoreCase(cont)) {
                display("Enter the text to be written");
                String text = getString();
                br.newLine();
                br.write(text);
                display("Any more data?");
                cont = getString();
            }
        } catch (IOException e) {
            display("Cannot create writer for document");
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ioe) {
                System.out.println("Error in closing the BufferedReader");
            }
        }

    }

    private static void wordCtr(File myFile) {
        display("Enter the word u want to count");
        Pattern pattern = Pattern.compile(getString());

        //String str = getString();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(myFile));
            String line = br.readLine();
            int count = 0;
            while (line != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    count++;
                }
                line = br.readLine();
            }
            display("word appears : " + count + " Times");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();

            } catch (IOException ioe) {
                display("Error in closing the BufferedReader");
            }
        }
    }

    private static void wordReplace(File myFile) {
        display("Enter the word u want to replace");
        String oldWord = getString();
        //Pattern pattern = Pattern.compile(getString());
        BufferedReader br = null;
        BufferedWriter br1 = null;
        display("Enter the new word");
        String newWord = getString();
        File tempFile = new File("tempFile.txt");

        try {
            br = new BufferedReader(new FileReader(myFile));
            br1 = new BufferedWriter(new FileWriter(tempFile));
            String line = br.readLine();


            while (line != null) {
                br1.write(line.replaceAll(oldWord, newWord)); //= matcher.replaceAll(newWord);
                line = br.readLine();
            }


            //display("word appears : "+ count +" Times");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (br1 != null)
                    br1.close();
                String name = myFile.getName();
                myFile.delete();
                tempFile.renameTo(new File(name));
            } catch (IOException ioe) {
                display("Error in closing the BufferedReader");
            }
        }

    }

    private static void changeCase(File src) {
        BufferedReader br = null;
        BufferedWriter br1 = null;
        File temp = new File("TempFile.txt");
        try {
            br = new BufferedReader(new FileReader(src));
            br1 = new BufferedWriter(new FileWriter(temp));
            String str = br.readLine();

            while (str != null) {
                StringBuffer dest = new StringBuffer();
                StringBuffer line = new StringBuffer(str);
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (Character.isUpperCase(c)) {
                        c = Character.toLowerCase(c);
                        dest.append(c);
                    } else {
                        c = Character.toUpperCase(c);
                        dest.append(c);
                    }

                }
                br1.write(dest.toString());
                str = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (br1 != null)
                    br1.close();
                String name = src.getName();
                src.delete();
                temp.renameTo(new File(name));
            } catch (IOException ioe) {
                display("Error in closing the BufferedReader");
            }
        }

    }
}
