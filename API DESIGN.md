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

| 所用方法 |               url                | 请求参数 |    返回参数    |                             描述                             |    控制器名    | 完成 |
| :------: | :------------------------------: | :------: | :------------: | :----------------------------------------------------------: | :------------: | ---- |
|   get    |      /{userId}/OwnTaskList       |  userId  | List<TaskList> |          根据所提交的用户id获取用户自定义的任务列表          | getOwnTaskList | 0    |
|   get    |         /{userId}/plans          |  userId  | List<TaskList> |         根据用户id返回所提交的计划（任务的分层结构）         |    getPlans    | 0    |
|   post   |        /{userId}/taskList        | TaskList |  stutus_code   | 用户提交描述一个任务列表的表单,可以提交到各个分类(由taskListId标识)中 |  addTaskList   | 0    |
|   put    |        /{userId}/taskList        | TaskList |  stutus_code   | 用户提交描述一个任务列表的表单,可以提交到各个分类(由taskListId标识)中 | updateTaskList | 0    |
|  delete  | /{userId}/taskList/{taskList_id} | task_id  |  stutus_code   |         根据删除的taskList_id删除taskList表中的数据          | deleteTaskList | 0    |

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



