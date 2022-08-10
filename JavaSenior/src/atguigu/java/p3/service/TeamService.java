package atguigu.java.p3.service;

import atguigu.java.p3.domain.Architect;
import atguigu.java.p3.domain.Designer;
import atguigu.java.p3.domain.Employee;
import atguigu.java.p3.domain.Programmer;

public class TeamService {
    private int counter = 1;//给memberId赋值
    private final int MAX_MEMBER = 5;//限制开发团队人数
    private Programmer[] team = new Programmer[MAX_MEMBER];//保存开发团队成员
    private int total = 0;//记录开发团队人数
//团队的增删改查


    public TeamService() {
    }

    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    //将指定员工添加开发团队
    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满");
        }
        if (!(e instanceof Programmer)) {
            throw new TeamException("非开发人员");
        }
        if (isExist(e)) {
            throw new TeamException("已在开发团队中");
        }
        Programmer p=(Programmer) e;

//        if ("BUSY".equals(p.getStatus().getNAME())){
//            throw new TeamException("已加入开发团队");
//        }else if ("VACATION".equals(p.getStatus().getNAME())){
//            throw new TeamException("该员工正在休假");
//        }

        switch (p.getStatus()){
            case BUSY -> throw new TeamException("已加入开发团队");
            case VOCATION -> throw new TeamException("该员工正在休假");
        }



        int numOfArch=0,numOfDes=0,numOfPro=0;
        for(int i=0;i<total;i++){
            if(team[i] instanceof Architect){
                numOfArch++;
            }else if (team[i] instanceof Designer){
                numOfDes++;
            }else {
                numOfPro++;
            }
        }
        if (p instanceof Architect){
            if (numOfArch>0){
                throw new TeamException("团队组多一名架构师");
            }
        }else if(p instanceof Designer){
            if (numOfDes>1){
                throw new TeamException("团队组多一名架构师");
            }
        }else if (p instanceof Programmer){
            if (numOfPro>2){
                throw new TeamException("团队组多一名程序员");
            }
        }
        team[total++]=p;
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);


    }



    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()) {
                return true;
            }
        }
        return false;
    }


    public void removeMember(int memberId) throws TeamException {
        int i=0;
        for (;i<total;i++){

            if (team[i].getMemberId()==memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if (i==total){
            throw new TeamException("找不到指定员工");
        } //后一个元素覆盖前一个元素
        for (int j=i+1;j<total;j++) {
            team[j - 1] =team[j];
        }
        team[--total]=null;


    }


}