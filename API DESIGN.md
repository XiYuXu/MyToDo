## API设计

### 关于用户（User）

| 所用方法 |        url        |               请求参数               | 返回参数  |         描述          |    控制器名    | 完成 |
| :------: | :---------------: | :----------------------------------: | :-------: | :-------------------: | :------------: | ---- |
|   post   |      /login       |           userId password            |  boolean  |   判断能否登录成功    |   verifyUser   | 1    |
|   put    | /settings/profile | userName\|password\|nickName\|avatar |  boolean  |     更新用户信息      |   updateUser   | 1    |
|   get    |   /user/profile   |           token中的userId            | user_data | 根据token获取用户信息 | getUserProfile | 1    |
|   post   |       /new        |       token的userId，User user       |  boolean  |       插入用户        |   insertUser   | 1    |
|   post   |   /setPassword    |       token中的userId，新密码        |  boolean  |       修改密码        |  setPassword   | 1    |



### 关于任务集合（TaskList）

| 所用方法 |              url               |    请求参数     |    返回参数    |               描述                |    控制器名    | 完成 |
| :------: | :----------------------------: | :-------------: | :------------: | :-------------------------------: | :------------: | ---- |
|   get    |          /OwnTaskList          | token中的userId | List<TaskList> | 根据token获取用户自定义的任务列表 | getOwnTaskList | 1    |
|   post   |         /TaskList/new          |    TaskList     |    boolean     |           新增任务列表            |  addTaskList   | 1    |
|   put    |        /TaskList/update        |    TaskList     |    boolean     |           更新任务列表            | updateTaskList | 1    |
|  delete  | /TaskList/{taskList_id}/delete |     task_id     |    boolean     |           删除任务列表            | deleteTaskList | 1    |

### 关于计划

| 所用方法 |     url      |    请求参数     |  返回参数  |                   描述                   |  控制器名  | 完成 |
| :------: | :----------: | :-------------: | :--------: | :--------------------------------------: | :--------: | ---- |
|   get    |   /OwnPlan   | token中的userId | List<Plan> |            获取用户自定义计划            | getOwnPlan | 1    |
|   post   |  /Plan/new   |    TaskList     |  boolean   |                 新增计划                 |  addPlan   | 1    |
|   put    | /Plan/update |    TaskList     |  boolean   | 更新计划的基础信息（未改变计划层级结构） | updatePlan | 1    |
|  delete  | /Plan/delete |     task_id     |  boolean   |           删除计划（层级删除）           | deletePlan | 0    |

### 关于任务（Task）

| 所用方法 |          url          |                      请求参数                       |  返回参数  |                            描述                             |       控制器名       | 完成 |
| :------: | :-------------------: | :-------------------------------------------------: | :--------: | :---------------------------------------------------------: | :------------------: | ---- |
|   get    |       /**/tasks       |                     taskListId                      | List<Task> |                        获取全部任务                         | getTasksByTaskListId | 1    |
|   get    |     /today/tasks      |                   token中的userId                   | List<Task> |                    获取某用户的今日任务                     |    getTodayTasks     | 1    |
|   post   |     /**/task/new      |                  Task、TaskListId                   |  boolean   |                     添加任务到taskList                      |  addTaskToTaskList   | 1    |
|   put    | /{userId}/task/taskId |                   task要改的信息                    |  boolean   | 用户提交描述一个任务的表单,可以修改分类(由taskListId标识)中 |      updateTask      | 0    |
|  delete  |    /**/task/delete    |                       task_id                       |  boolean   |             根据删除的task_id删除task表中的数据             |      deleteTask      | 0    |
|   post   |     /**/task/move     | taskId、taskList_Id（源列表）、taskListId（新列表） |  boolean   |             把某个task从一个分类中转移到另一个              |       moveTask       | 0    |



