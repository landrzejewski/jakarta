package pl.training.jakarta;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class ReportGenerator {

    @Schedule(second = "*/30", minute = "*", hour = "*", persistent = false)
    public void generate() {
        System.out.println("Generating report");
    }

}
