//what it means to be a reseracher, like what makes you qualify, 
//teachers and studnets, bachelor studnets, employees can be researchers, this is decided by the manager or the admin, with setresearcher()
//professors(teachers) are always researchers
//papers and projects are gonna be lists since they might have worke don more than one paper, more than one project

//th eproject requires printPaper()sorted by (citations, date, length  )

package Research;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public interface Researcher {

    List<ResearchPaper> getResearchPapers();
    List<ResearchProject>getResearchProjects();

    void setResearchPapers(List<ResearchPaper> papers);
    void setResearchProjects(List<ResearchProject> projects);


   default void addResearchPaper(ResearchPaper paper){
        getResearchPapers().add(paper);};

    default void addResearchProject(ResearchProject project){
        getResearchProjects().add(project);

    };


    default int getHindex(){
        List<Integer>citations=new ArrayList<>();

        for(ResearchPaper paper: getResearchPapers()){
            citations.add(paper.getCitations());
        }


        citations.sort(Collections.reverseOrder());

 
    int h=0;
    for(int i=0; i<citations.size();i++){
        if(citations.get(i)>=i+1){
            h=i+1;
        }else{break;}
        
    }return h;   }



    default int getTotalcitations(){
        int total=0;
        for(ResearchPaper paper: getResearchPapers()){
            total+=paper.getCitations();
        }
        return total;
    }

    default int getPapercount(){
        return getResearchPapers().size();

    }



    default void printpapers(Comparator <ResearchPaper> comparator){
    List<ResearchPaper>sorted=new ArrayList<>(getResearchPapers());
    sorted.sort(comparator);
    System.out.println("we have "+getPapercount()+ "papers");
    for(ResearchPaper paper:sorted){
        System.out.println(paper);
    }

}


    
}
