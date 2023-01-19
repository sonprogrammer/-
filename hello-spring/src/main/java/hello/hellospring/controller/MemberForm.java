package hello.hellospring.controller;

public class MemberForm { //웹 등록 화면에서 데이터를 전달 받을 폼 객체,
    //MemberController에서 /members/new에서 이름을 등록하면 그name값을 여기서 받아준다
    private String name;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

}

