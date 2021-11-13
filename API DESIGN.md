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

| 所用方法 |                        url                        |                      请求参数                       |  返回参数   |                             描述                             |       控制器名       | 完成 |
| :------: | :-----------------------------------------------: | :-------------------------------------------------: | :---------: | :----------------------------------------------------------: | :------------------: | ---- |
|   get    |                /{userId}/allTasks                 |                       userId                        | List<Task>  |                   获取某一个用户的总任务表                   |     getAllTasks      | 0    |
|   get    |               /{userId}/todayTasks                |                       userId                        | List<Task>  |                     获取某用户的今日任务                     |    getTodayTasks     | 0    |
|   post   |            /{userId}/{taskListId}/task            |                  Task、TaskListId                   | stutus_code | 用户提交描述一个任务的表单,可以提交到各个分类(由taskListId标识)中 |       addTask        | 0    |
|   get    |           /{userId}/{TaskListId}/tasks            |                  userId,taskListId                  | List<Task>  |  根据所提交的用户id和任务列表id获取该自定义分类下的所有任务  | getTasksByTaskListId | 0    |
|   put    |               /{userId}/task/taskId               |                        task                         | stutus_code | 用户提交描述一个任务的表单,可以修改分类(由taskListId标识)中  |      updateTask      | 0    |
|  delete  |             /{userId}/task/{task_Id}              |                       task_id                       | stutus_code |             根据删除的task_id删除task表中的数据              |      deleteTask      |      |
|   put    |               /{userId}/task/taskId               |                        task                         | stutus_code | 用户提交描述一个任务的表单,可以修改分类(由taskListId标识)中  |      updateTask      | 0    |
|   post   | /{userId}/task/{taskId}/{taskListId}/{taskListId} | taskId、taskList_Id（源列表）、taskListId（新列表） | stutus_code |              把某个task从一个分类中转移到另一个              |       moveTask       | 0    |



