import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2000-10-10");
        assertEquals(null, data.getDate());
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("", "description", "2030-10-10");
        assertEquals(null, data.getDescription());
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        assertEquals("2030-10-10", data.getDate());
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        assertEquals("description", data.getDescription());
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        assertEquals("invalid due date; due date not updated", data.setDate("1990-19-19"));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        data.setDate("2020-12-12");
        assertEquals("2020-12-12", data.getDate());
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        assertEquals("Name must be at least one character, name not updated", data.setTitle(""));
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        data.setTitle("NEW TITLE");
        assertEquals("NEW TITLE", data.getTitle());
    }
}