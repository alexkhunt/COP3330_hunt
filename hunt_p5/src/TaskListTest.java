import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {
    @Test
    public void addingTaskItemsIncreasesSize(){
        TaskList test = new TaskList();
        int x = test.getSize();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        int y = test.getSize();
        assertTrue(y > x);
    }

    @Test
    public void completingTaskItemChangesStatus(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        test.markItemCompleted(0);
        assertEquals(true, data.getCompleted());
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        test.markItemCompleted(5);
        assertEquals(false, data.getCompleted());
    }

    @Test
    public void editingTaskItemChangesValues(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        test.editTaskItem("title2", "description2", "2030-12-12", 0);
        assertEquals("title2", data.getTitle());
        assertEquals("description2", data.getDescription());
        assertEquals("2030-12-12", data.getDate());
    }

    @Test
    public void editingTaskItemDescriptionChangesValue(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        test.editTaskItem("title2", "description2", "2030-12-12", 0);
        assertEquals("description2", data.getDescription());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        test.editTaskItem("title2", "description2", "2030-12-12", 1);
        assertEquals("description", data.getDescription());
    }

    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        test.editTaskItem("title2", "description2", "2030-12-12", 0);
        assertEquals("2030-12-12", data.getDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        test.editTaskItem("title2", "description2", "2030-12-12", 1);
        assertEquals("2030-10-10", data.getDate());
    }

    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        test.editTaskItem("title2", "description2", "2030-12-12", 0);
        assertEquals("title2", data.getTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        test.editTaskItem("title2", "description2", "2030-12-12", 1);
        assertEquals("title", data.getTitle());
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        assertEquals("Out of bounds exception", test.getDescription(1));
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        assertEquals("description", test.getDescription(0));
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        assertEquals("Out of bounds exception", test.getDueDate(1));
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        assertEquals("2030-10-10", test.getDueDate(0));
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        assertEquals("Out of bounds exception", test.getTitle(1));
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10");
        assertEquals("title", test.getTitle(0));
    }

    @Test
    public void newTaskListIsEmpty(){
        TaskList test = new TaskList();
        assertEquals(0, test.getSize());
    }

    @Test
    public void removingTaskItemsDecreasesSize(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title1", "description1", "2030-10-10");
        TaskItem data2 = new TaskItem("title2", "description2", "2030-10-10");
        int y = test.getSize();
        test.removeTaskItem(1);
        int x = test.getSize();
        assertTrue(y > x);
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title1", "description1", "2030-10-10");
        TaskItem data2 = new TaskItem("title2", "description2", "2030-10-10");
        assertEquals("Invalid index, no item deleted", test.removeTaskItem(3));
    }

    @Test
    public void savedTaskListCanBeLoaded(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title1", "description1", "2030-10-10");
        test.saveTaskList("tasks.txt");
        test.listLoader("tasks.txt");
        assertEquals("title1", test.getTitle(0));
    }

    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10", true);
        test.markItemUncompleted(0);
        assertEquals(false, test.getCompleted(0));
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskList test = new TaskList();
        TaskItem data = new TaskItem("title", "description", "2030-10-10", true);
        test.markItemUncompleted(5);
        assertEquals(true, test.getCompleted(0));
    }
}