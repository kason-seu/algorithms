package data.structure.unionfind.demos;

import com.google.common.collect.Lists;
import data.structure.unionfind.UnionSetArr;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

public class Demo2SameStudents {
    @Data
    @AllArgsConstructor
    static class Student {
        public String certId;
        public String bid;
        public String githubId;
    }
    public static void main(String[] args) {
        List<Student> schoolStudents = new ArrayList<>();

        Student s1 = new Student("1234567", "b1", "xxx1@github.com");
        Student s2 = new Student("1234567", "b123", "tytututu@github.com");
        Student s3 = new Student("123456789", "b456", "xxx3@github.com");
        Student s4 = new Student("12345677777", "b123", "xxxwwwwwww@github.com");

        schoolStudents.add(s1);
        schoolStudents.add(s2);
        schoolStudents.add(s3);
        schoolStudents.add(s4);
        Demo2SameStudents demo2SameStudents = new Demo2SameStudents();
        int studentNumber = demo2SameStudents.findStudentNumber(schoolStudents);
        System.out.println(studentNumber);
    }

    private Map<String, List<Integer>> certIds = new HashMap<>();
    private Map<String, List<Integer>> bids = new HashMap<>();
    private Map<String, List<Integer>> githubIds = new HashMap<>();
    private UnionSetArr<Student> unionSetArr;
    private int findStudentNumber(List<Student> schoolStudents) {
        unionSetArr = new UnionSetArr<>(schoolStudents);
        int index = 0;
        for (Student s : schoolStudents) {
            if (certIds.get(s.getCertId()) == null ) {
                certIds.put(s.getCertId(), Lists.newArrayList(index));
            } else {
                certIds.get(s.getCertId()).add(index);
            }

            if (bids.get(s.getBid()) == null ) {
                bids.put(s.getBid(), Lists.newArrayList(index));
            } else {
                bids.get(s.getBid()).add(index);
            }

            if (githubIds.get(s.getGithubId()) == null ) {
                githubIds.put(s.getGithubId(), Lists.newArrayList(index));
            } else {
                githubIds.get(s.getGithubId()).add(index);
            }
            index++;
        }
        unionSameElement(certIds, unionSetArr);
        unionSameElement(bids, unionSetArr);
        unionSameElement(githubIds, unionSetArr);
        return unionSetArr.getClusterSize();
    }

    private void unionSameElement(Map<String, List<Integer>> elements, UnionSetArr<Student> union) {
        elements.forEach((key, value) -> {
            for (int i = 0; i < value.size() - 1; i++) {
                for (int j = i + 1; j < value.size(); j++) {
                    union.unionElement(value.get(i), value.get(j));
                }
            }
        });
    }

}
