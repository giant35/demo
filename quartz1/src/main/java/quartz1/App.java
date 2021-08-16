package quartz1;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@SpringBootApplication
public class App {

    @Autowired
    Scheduler scheduler;


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


    private final static class MyJob implements Job {

        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            System.out.println("myjob execute.... " + Thread.currentThread().getName() + " date:" + LocalDateTime.now());
        }
    }

    @Bean
    public CommandLineRunner ss(String[] args) throws SchedulerException {
        return (a) -> {
//需要执行一次
//            var job = newJob(MyJob.class).build();
//            Trigger trigger = newTrigger().startNow().withSchedule(simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();
//            scheduler.scheduleJob(job, trigger);
        };
    }
}
