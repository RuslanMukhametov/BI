package Test1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by Руслан on 12.09.2015.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pcbWidth = 250;
        int pcbHeight = 250;
        /*System.out.println("Введите количество итераций");
        int iter = scanner.nextInt();*/
        int iter = 20;
        int[][] matrix;
        /*System.out.println("Введите количество элементов:");
        int numb = scanner.nextInt();*/
        int numb = 3;
        matrix = new int[numb][numb];
        /*System.out.println("Заполните матрицу смежности.");*/
        for (int i = 0; i < numb; i++) {
            for (int j = i + 1; j < numb; j++){
                System.out.println("Введите количество соединений " + " " + i + " и " + j + " элементов:");
                int first = scanner.nextInt();
                //int first = 1;
                matrix[i][j] = first;
            }
        }
        for (int i = 0; i < numb; i++) {
            for (int x = 0; x < numb; x++) {
                matrix[x][i] = matrix[i][x];
            }
        }
        for (int i = 0; i < numb; i++) {
            for (int x = 0; x < numb; x++) {
                System.out.print(matrix[i][x] + "\t");
            }
            System.out.println();
        }
        ArrayList<Element> elements = new ArrayList<Element>();
        ArrayList<Element> initialPlacement = new ArrayList<Element>();
        for (int i = 0; i < numb; i++){
            System.out.println("Введите координату центра элемента " + i + " по Х");
            int centreX = scanner.nextInt();
            System.out.println("Введите координату центра элемента " + i + " по У");
            int centreY = scanner.nextInt();
            System.out.println("Введите ширину элемента " + i);
            int width = scanner.nextInt();
            System.out.println("Введите высоту элемента " + i);
            int height = scanner.nextInt();
            Element element = new Element(centreX, centreY, width, height);
            Element element1 = new Element(centreX, centreY, width, height);
            elements.add(element);
            initialPlacement.add(element1);
        }

        for (int i = 0; i < elements.size(); i++){
            System.out.print("Координаты центров элементов по Х:");
            System.out.println(elements.get(i).getCentreX() + " ");
            System.out.print("Координаты центров элементов по У:");
            System.out.println(elements.get(i).getCentreY() + " ");
        }
        System.out.println("Количество элементов = " + elements.size());
        /*JFrame window = new MainWindow();
        window.setVisible(true);
        Paint paint = new Paint(elements);
        window.add(paint);*/

        //Проводим выполнение алгоритма, выполняем перемещение
        // и сохраняем новые значения центров элементов
        //в соответствующих списках
        System.out.println("Начинаем выполнять алгоритм " + iter +" количество раз");
        for (int j = 0; j < iter; j++) {
            for (int i = 0; i < elements.size(); i++) {
                elements.get(i).setCentreX(Algorithm.movingX(elements.get(i).getCentreX()));
                elements.get(i).setCentreY(Algorithm.movingY(elements.get(i).getCentreY()));
            }
            System.out.println("После выполнения " + j + " итерации:" );
            for (int i = 0; i < elements.size(); i++){
                System.out.print("Координаты центра элемента " + i + " по Х:");
                System.out.println(elements.get(i).getCentreX() + " ");
                System.out.print("Координаты центра элемента " + i + " по У:");
                System.out.println(elements.get(i).getCentreY() + " ");
            }
        }

        System.out.println("После выполнения алгоритма");
        for (int i = 0; i < elements.size(); i++){
            System.out.print("Координаты центра элемента " + i + " по Х:");
            System.out.println(elements.get(i).getCentreX() + " ");
            System.out.print("Координаты центра элемента " + i + " по У:");
            System.out.println(elements.get(i).getCentreY() + " ");
        }
        System.out.println("Значение целевой функции = " + Algorithm.targetFunction(matrix, elements));
        JFrame window = new MainWindow();
        window.setVisible(true);
        Paint paint = new Paint(initialPlacement, elements, pcbWidth, pcbHeight);
        window.add(paint);


    }
}
