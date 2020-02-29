package com.xiaokunliu.j2se.javase.io.test.stu;

import com.xiaokunliu.j2se.javase.bean.StudentBean;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ReadAndWriteTool {

    private static final String OVER = "over";
    private static ReadAndWriteTool tool = null;
    private BufferedReader br;

    private ReadAndWriteTool() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public static ReadAndWriteTool getReadAndWriteTool() {

        if (tool == null) {
            tool = new ReadAndWriteTool();
        }
        return tool;
    }

    public Set<StudentBean> getStudent() throws IOException {
        return getStudent(null);
    }

    public Set<StudentBean> getStudent(Comparator<StudentBean> com) throws IOException {
        System.out.println("请输入学生的姓名，英语、语文和数学成绩，并以英文分号结尾，输入over表示输入完毕");
        Set<StudentBean> set = null;
        if (com != null) {
            set = new TreeSet<StudentBean>(com);
        } else {
            set = new TreeSet<StudentBean>();
        }
		/*
		 * 	aa,89,78,78
			bb,90,89,78
			cc,79,80,70
			dd,78,78,90
			ee,80,78,87
			over
		 */
        String line = null;
        while ((line = br.readLine()) != null) {
            if (OVER.equals(line))
                break;
            String[] arr = line.split(",");
            StudentBean st = new StudentBean(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]),
                    Integer.parseInt(arr[3]));
            set.add(st);
        }
        return set;
    }


    public void write2File(Set<StudentBean> set, File file) throws IOException {
        if (!file.exists())
            file.createNewFile();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (StudentBean stu : set) {
            bw.write("name:" + stu.getName() + "\t" + "English" + stu.getEn() + "\t"
                    + "Chiense" + stu.getZn() + "\t" + "Math:" + stu.getMath() + "\t" + "Sum:" + stu.getSum());
            bw.newLine();
            bw.flush();
        }
        if (bw != null)
            bw.close();

    }


    public void close() {
        try {
            if (br != null)
                br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
