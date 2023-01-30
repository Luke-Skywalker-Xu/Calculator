# Calculator

![Windows](https://github.com/Luke-Skywalker-Xu/IconPark/blob/main/resources/Img/badge_Windows.svg)
![Ubuntu](https://github.com/Luke-Skywalker-Xu/IconPark/blob/main/resources/Img/badge_Ubuntu.svg)
![MacOS](https://github.com/Luke-Skywalker-Xu/IconPark/blob/main/resources/Img/badge_MacOS.svg)

[中文介绍](README_zh.md)

A calculator software based on JavaFX

It focuses on:
 - **style** (switch the calculator button style)
 - **Multifunction** (Multiple calculation mode options)
 - **Cross-platform** (It supports three major platforms: GNU/Linux, Windows and macOS)
 
 ## Building Calculator
 ### Building Prerequisites
To build Calculator, make sure that the following tools or libraries are available on your Windows, Linux or macOS system:
1. openjdk: 1.8.0
2. Maven: 3.8.1


 <span id="Compile it yourself" > </span>

## Building Artifacts Calculator 
 
We assume that you are using IntelliJ IDEA 

First pull the code in IntelliJ IDEA, you can copy to use this code
 
<pre><code>git clone https://github.com/Luke-Skywalker-Xu/Calculator.git</code></pre>

Step:

1. File -> Projects Structure 
2. Project Settings -> Artifacts - > + (Add) -> JavaFx Application -> From Module'Calculator' -> JavaFx

<details>
<summary>JavaFx configuration (required)</summary>

1. Application class -> MainApplication(org.luke) -> OK
2. Title: Calculator 
3. Native bundle: all
4. Apply

</details>

3. File -> Projects Structure 
4. Project Settings -> Artifacts - > + (Add) -> JavaFx Application -> From Module'Calculator' -> JavaFx
5. Build -> Build Artifacts... -> Calculator -> Build

After the build is complete, the executable file path: out/artifacts/Calculator/bundles/Calculator

Then double-click the calculator in the file to run the software

 ## Download 
You can directly use my compiled executable program:
 
  - **Windows** ([Download](https://github.com/Luke-Skywalker-Xu/Calculator/releases))
  - **linux** ([Download](https://github.com/Luke-Skywalker-Xu/Calculator/releases))

At present, only executable programs for windows and linux platforms are provided. If you need executable programs for MacOS platforms.
compile it yourself
<a href="#Compile it yourself">Compile it yourself</a>


