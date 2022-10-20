package dev.ers.entities;

public class Coverage {
    private int coverageid;
    private String coveragename;
    private int coveragepercentage;
    public Coverage(){

    }
    public Coverage(int coverageid,String coveragename,int coveragepercentage){
        this.coverageid=coverageid;
        this.coveragename=coveragename;
        this.coveragepercentage=coveragepercentage;
    }

    public int getCoverageid(){
        return coverageid;
    }
    public void setCoverageid(int coverageid){
        this.coverageid=coverageid;
    }
    public String getCoveragename(){
        return coveragename;
    }
    public void setCoveragename(String coveragename){
        this.coveragename=coveragename;
    }
    public int getCoveragepercentage(){
        return coveragepercentage;
    }
    public void setCoveragepercentage(int coveragepercentage){
        this.coveragepercentage=coveragepercentage;
    }

    @Override
    public String toString() {
        return "Coverage{" +
                "coverageid=" + coverageid +
                ", coveragename='" + coveragename + '\'' +
                ", coveragepercentage=" + coveragepercentage +
                '}';
    }
}
