package COMPULSORY;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hospital implements Comparable<Hospital>{
    private String name;
    private int capacity;
    private List<Resident> residentList;

    public Hospital(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        residentList = new ArrayList<>();
    }

    public Hospital(String name, int capacity, Resident ... residentList) {
        this.name = name;
        this.capacity = capacity;
        if(residentList.length <= capacity){
            Collections.addAll(this.residentList,residentList);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Resident> getResidentList() {
        return residentList;
    }

    public void setResidentList(List<Resident> residentList) {
        this.residentList = residentList;
    }

    public void addResident(Resident resident) {
        if (residentList.size() + 1 <= capacity) {
            residentList.add(resident);
        }
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Hospital hospital) {
        return this.getName().compareTo(hospital.getName());
    }
}
