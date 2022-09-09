# 无内循环结构
import json
import pandas as pd

st = ''  # 定义字符串，将文件读取出来
with open("/Users/admin/Downloads/EdcData_20220627094846_20090815.json", encoding='utf-8') as file:
    st = file.read()
m = json.loads(st)

dat = m["Data"]  # 选取subjectinfo这个表
columns = ["Code", "ScreeningNo", "RandomNo", "RegisterDate", "JoinDate", "StartDate", "GroupName",
           "EndDate", "Initial", "Gender", "Birthday", "Age", "Nation", "Race", "Job", "Marital", "DataNo"]  # 保存列表，确定表头

# for i in p.keys():
# columns.append(i)

da = []
for t in dat:  # 选取每一个对象，将里面的值取出来
    subinfo = t["SubjectInfo"]
    code = subinfo["Code"]
    scno = subinfo["ScreeningNo"]
    RandomNo = subinfo["RandomNo"]
    RegisterDate = subinfo["RegisterDate"]
    JoinDate = subinfo["JoinDate"]
    StartDate = subinfo["StartDate"]
    GroupName = subinfo["GroupName"]
    EndDate = subinfo["EndDate"]
    Initial = subinfo["Initial"]
    Gender = subinfo["Gender"]
    Birthday = subinfo["Birthday"]
    Age = subinfo["Age"]
    Nation = subinfo["Nation"]
    Race = subinfo["Race"]
    Job = subinfo["Job"]
    Marital = subinfo["Marital"]
    DataNo = subinfo["DataNo"]
    # print(type(t["SubjectInfo"]))
    # exit()

    for u in subinfo:  # 输入对应的表名称，如AE

        data = []  # 保存内容
        data.append(code)
        data.append(scno)
        data.append(RandomNo)
        data.append(RegisterDate)
        data.append(JoinDate)
        data.append(StartDate)
        data.append(GroupName)
        data.append(EndDate)
        data.append(Initial)
        data.append(Gender)
        data.append(Birthday)
        data.append(Age)
        data.append(Nation)
        data.append(Race)
        data.append(Job)
        data.append(Marital)
        data.append(DataNo)
        print(u)
        # for m in u.keys():
        # print(u)
        # data.append(str(u[m]))
        da.append(data)
filecvs2 = pd.DataFrame(columns=columns, data=da)
filecvs2.to_csv('/Users/admin/Downloads/SubjectInfo.csv', encoding='utf-8-sig', index=False)
