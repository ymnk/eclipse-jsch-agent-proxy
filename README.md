# eclipse-jsch-agent-proxy
plug-ins to use ssh-agent and Pageant on Eclipse

## Description
This project provides Eclipse Plug-ins to use [OpenSSH](http://www.openssh.com/)'s [ssh-agent](http://en.wikipedia.org/wiki/Ssh-agent) and [Pageant](http://en.wikipedia.org/wiki/PuTTY#Applications) on Eclipse.
Provided plug-ins depend on [jsch-agent-proxy](http://www.jcraft.com/jsch-agent-proxy/). This is an effort for [Bug179924](https://bugs.eclipse.org/bugs/show_bug.cgi?id=179924).


## How to try
1.   Those plug-ins expect jsch-0.1.49.

     It is available at Eclipse Plug-in update site [http://eclipse.jcraft.com/](http://eclipse.jcraft.com/).
     Install that version through the menue,
     
     > Help > Install New Software...
2.    Those plug-ins expect some changes for org.eclipse.jsch.{core, ui} plugins, and modified version is avalbale at
     [https://github.com/ymnk/eclipse.platform.team/tree/bug179924](https://github.com/ymnk/eclipse.platform.team/tree/bug179924)
     Check out that branch into the workspace.
3.    Checkout plug-ins provided by this project into the workstapce.

     If you are not interested in the source code, install plug-ins named as "JSch Agent Porxy Plug-in" at Eclipse Plug-in update site [http://eclipse.jcraft.com/](http://eclipse.jcraft.com/) after step 4.
4.    Run Eclipse with those plug-ins,
    
     > Run > Run As > Eclipse Application
5.    Choose the ssh agent you want to use,
   
     > Window > Preferences > General > Network Connections > SSH2 > SSH Agent
6.   Try CVS or EGit plug-in.

## License
This software is licensed under revised BSD license, and depends on other software.

* com.jcraft.jsch.agentproxy.eclipse.pageant is using [JNA](https://github.com/twall/jna), which is licensed under [Apache License, Version 2.0](https://github.com/twall/jna/blob/master/LICENSE).
* com.jcraft.jsch.agentproxy.eclipse.sshagent is using [JNA](https://github.com/twall/jna), which is licensed under [Apache License, Version 2.0](https://github.com/twall/jna/blob/master/LICENSE).

