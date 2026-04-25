// the project requires to print the resaerch paper sof all the resaercher s in the university(they have to be sorted by date|| citation||length of research )


package Research;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ResearchDELO {

    public static void printAllPapers(List<Researcher>Allresearchers, Comparator<ResearchPaper>comparator){
        List<ResearchPaper> Allpapers=new ArrayList<>();


        for (Researcher researcher:Allresearchers){
            Allpapers.addAll(researcher.getResearchPapers());

        }
        Allpapers.sort(comparator);
        System.out.println("this researcher has "+Allpapers.size()+ "papers");

        for(ResearchPaper paper:Allpapers){
            System.out.println(paper);
        }
    }
    



    public static Researcher getTopCited(List<Researcher> researchers){
        if(researchers==null || researchers.isEmpty())return null;
        Researcher Topcited=researchers.get(0);
        for(Researcher r:researchers  ){
            if(r.getTotalcitations()>Topcited.getTotalcitations()){
                Topcited=r;

            }

        }
        return Topcited;

    }

}
