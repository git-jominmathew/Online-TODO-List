package com.ey.todo.model;


import javax.persistence.*;

@Entity
@Table(name = "TODO_TBL")
public class ToDoEntiy {
    @Column
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String task;
    @Column
    private Boolean done;
    @Column
    private String lastUpdateTime;


    /**
     * get field @Column
     @Id

      *
      * @return id @Column
     @Id

     */
    public int getId() {
        return this.id;
    }

    /**
     * set field @Column
     @Id

      *
      * @param id @Column
     @Id

     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get field @Column
     *
     * @return task @Column

     */
    public String getTask() {
        return this.task;
    }

    /**
     * set field @Column
     *
     * @param task @Column

     */
    public void setTask(String task) {
        this.task = task;
    }

    /**
     * get field @Column
     *
     * @return isDone @Column

     */
    public Boolean getDone() {
        return this.done;
    }

    /**
     * set field @Column
     *
     * @param done @Column

     */
    public void setDone(Boolean done) {
        this.done = done;
    }

    /**
     * get field @Column
     *
     * @return lastUpdateTime @Column

     */
    public String getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    /**
     * set field @Column
     *
     * @param lastUpdateTime @Column

     */
    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
