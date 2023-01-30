# Calculator

![Windows](https://github.com/Luke-Skywalker-Xu/IconPark/blob/main/resources/Img/badge_Windows.svg)
![Ubuntu](https://github.com/Luke-Skywalker-Xu/IconPark/blob/main/resources/Img/badge_Ubuntu.svg)
![MacOS](https://github.com/Luke-Skywalker-Xu/IconPark/blob/main/resources/Img/badge_MacOS.svg)

[English introduction](README.md)

一款基于JavaFX的计算器软件

它着重于:
- **样式** (切换计算器按钮样式)
- **多功能** (多种计算模式选项)
- **跨平台** (支持三大平台：GNU/Linux、Windows和MacOS)

## 构建Calculator
### 构建先决条件
要构建计算器，请确保以下工具或库在您的 Windows、Linux 或 macOS 系统上可用：
1. openjdk: 1.8.0
2. Maven: 3.8.1

 <span id="自己编译" > </span>
## Building Artifacts Calculator 

我们假设您正在使用 IntelliJ IDEA

先拉取IntelliJ IDEA中的代码，你可以复制使用这段代码

<pre><code>git clone https://github.com/Luke-Skywalker-Xu/Calculator.git</code></pre>

步骤:

1. File -> Projects Structure
2. Project Settings -> Artifacts - > + (Add) -> JavaFx Application -> From Module'Calculator' -> JavaFx

<details>
<summary>JavaFx配置 (required)</summary>

1. Application class -> MainApplication(org.luke) -> OK
2. Title: Calculator
3. Native bundle: all
4. Apply

</details>

3. File -> Projects Structure
4. Project Settings -> Artifacts - > + (Add) -> JavaFx Application -> From Module'Calculator' -> JavaFx
5. Build -> Build Artifacts... -> Calculator -> Build

构建完成后，可执行文件路径：out/artifacts/Calculator/bundles/Calculator

然后双击文件中的计算器运行软件

## 下载 
你可以直接使用我编译好的可执行程序:

- **Windows** ([Download](https://github.com/Luke-Skywalker-Xu/Calculator/releases))
- **linux** ([Download](https://github.com/Luke-Skywalker-Xu/Calculator/releases))

目前只提供windows和linux平台的可执行程序。 如果您需要适用于 MacOS 平台的可执行程序。

<a href="#Compile it yourself">自己编译</a>


