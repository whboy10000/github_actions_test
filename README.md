# GitHub Actions + Maven 实战案例

## 项目简介

这是一个用于演示 **GitHub Actions 持续集成(CI)** 的 Java Maven 项目实战案例。
项目包含一个简单的计算器服务和问候服务，配有完整的单元测试。

## 项目结构

```
github-actions-maven-demo/
├── .github/
│   └── workflows/
│       └── maven.yml              # GitHub Actions 工作流配置
├── src/
│   ├── main/java/com/example/
│   │   ├── App.java               # 主程序入口
│   │   ├── model/
│   │   │   └── Calculator.java    # 计算器模型
│   │   └── service/
│   │       └── GreetingService.java  # 问候服务
│   └── test/java/com/example/
│       └── service/
│           ├── CalculatorTest.java    # 计算器单元测试
│           └── GreetingServiceTest.java  # 问候服务单元测试
├── pom.xml                        # Maven 项目配置
└── README.md                      # 项目说明
```

## 快速开始 - 本地运行

### 前置条件
- 已安装 **JDK 17** 或更高版本
- 已安装 **Maven 3.6+**
- 已安装 **Git**

### 构建和运行

```bash
# 1. 克隆项目
git clone <你的仓库地址>
cd github-actions-maven-demo

# 2. 编译项目
mvn clean compile

# 3. 运行测试
mvn test

# 4. 打包项目
mvn package

# 5. 运行程序
mvn exec:java -Dexec.mainClass="com.example.App"
# 或者直接运行 JAR:
java -jar target/github-actions-maven-demo-1.0-SNAPSHOT.jar
```

## GitHub Actions 工作流详解

### 工作流文件: `.github/workflows/maven.yml`

该文件定义了完整的 CI 流水线，包含两个 Job：

**Job 1: `build` - 构建和测试**
- 触发条件：推送到 main/master 分支 或 创建拉取请求
- 步骤：
  1. `actions/checkout@v6` - 检出代码
  2. `actions/setup-java@v4` - 设置 JDK 17 环境
  3. `actions/cache@v4` - 缓存 Maven 依赖（加速后续构建）
  4. `mvn verify` - 执行编译、测试、打包
  5. `actions/upload-artifact@v4` - 上传构建产物

**Job 2: `checkstyle` - 代码风格检查**
- 依赖 build job 成功完成后执行
- 执行 Checkstyle 代码风格检查

### 工作流触发时机

| 触发方式 | 说明 |
|---------|------|
| `push` | 推送到 main/master 分支时自动触发 |
| `pull_request` | 创建/更新针对 main/master 的 PR 时触发 |
| `workflow_dispatch` | 在 GitHub 界面手动点击触发（需取消注释） |

## 部署到 GitHub 实现自动执行

### 步骤 1: 初始化 Git 仓库

```bash
git init
git add .
git commit -m "Initial commit: GitHub Actions Maven CI demo"
```

### 步骤 2: 在 GitHub 创建远程仓库

1. 登录 GitHub，点击页面右上角的 **+** 号 → **New repository**
2. 填写仓库名称（如 `github-actions-maven-demo`）
3. 选择 **Public** 或 **Private**
4. 不要勾选 "Initialize this repository with a README"（因为我们已有 README）
5. 点击 **Create repository**

### 步骤 3: 关联远程仓库并推送

```bash
# 添加远程仓库地址（替换为你的用户名和仓库名）
git remote add origin https://github.com/你的用户名/github-actions-maven-demo.git

# 推送代码到远程仓库（自动创建 main 分支）
git branch -M main
git push -u origin main
```

### 步骤 4: 验证 GitHub Actions 运行

1. 打开你的 GitHub 仓库页面
2. 点击顶部导航栏的 **Actions** 标签
3. 你应该能看到工作流正在运行（或刚刚运行完成）
4. 点击具体的运行记录，查看每个 Step 的执行日志
5. 如果所有测试通过，你会看到绿色的勾勾标记

### 步骤 5: 测试拉取请求触发

```bash
# 创建新分支并修改代码
git checkout -b feature-test
# 修改一些代码...
git add .
git commit -m "Add new feature"
git push origin feature-test

# 在 GitHub 上创建 Pull Request
# 打开浏览器访问你的仓库，你会看到 "Compare & pull request" 按钮
# 点击创建 PR，GitHub Actions 会自动触发构建和测试
```

## 自定义工作流

### 修改 Java 版本
编辑 `.github/workflows/maven.yml` 中的 `java-version` 参数：

```yaml
- name: Set up JDK 17
  uses: actions/setup-java@v4
  with:
    java-version: '21'    # 改为 21
    distribution: 'temurin'
```

### 添加更多触发分支
```yaml
on:
  push:
    branches: [ main, master, develop, 'release/**' ]
```

### 启用定时构建（如每天凌晨构建）
```yaml
on:
  schedule:
    - cron: '0 0 * * *'  # 每天 UTC 00:00
```

## 常见问题

### Q: 工作流一直显示 "Pending"？
A: 检查你的 GitHub 仓库设置中 Actions 是否被启用（Settings > Actions > General > Workflow permissions）。

### Q: 测试失败怎么办？
A: 查看 Actions 页面中具体失败的 Step 日志，定位问题代码并修复后重新推送。

### Q: 如何跳过某些 Step？
A: 可以在 Step 中使用 `if` 条件判断，如 `if: github.event_name == 'push'`。

---

**项目技术栈：** Java 17 + Maven 3.6+ + JUnit 5 + GitHub Actions
