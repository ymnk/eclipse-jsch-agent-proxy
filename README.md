# eclipse-jsch-agent-proxy
plug-ins to use ssh-agent and Pageant on Eclipse

## Description
This is an effort for [Bug179924](https://bugs.eclipse.org/bugs/show_bug.cgi?id=179924), and
this project provides Eclipse Plug-ins to use [OpenSSH](http://www.openssh.com/)'s [ssh-agent](http://en.wikipedia.org/wiki/Ssh-agent) and [Pageant](http://en.wikipedia.org/wiki/PuTTY#Applications) on Eclipse.
Provided plug-ins depend on [jsch-agent-proxy](http://www.jcraft.com/jsch-agent-proxy/)

## How to try
+    Those plugins expect jsch-0.1.49.
     It is available at Eclipse Plug-in update site [http://eclipse.jcraft.com/site.xml](http://eclipse.jcraft.com/site.xml)
     Install that version through the menue,
     Help > Install New Software...
+    Those plugins expect some changes for org.eclipse.jsch.{core, ui} plugins, and modified version is avalbale at
     [https://github.com/ymnk/eclipse.platform.team/tree/bug179924](https://github.com/ymnk/eclipse.platform.team/tree/bug179924)
     Check out that branch into the workspace.
+    Checkout plugins into the workstapce.
     If you are not interested in the source code, plug-ins are available as "JSch Agent Porxy Plug-in" at [http://eclipse.jcraft.com/site.xml](http://eclipse.jcraft.com/site.xml).
+    Run > Run As > Eclipse Application
+    Choose the ssh agent you want to use,
     Window > Preferences > General > Network Connections > SSH2 > SSH Agent
+ Try CVS or EGit plugin.

## License
This software is licensed under revised BSD license, but is using [JNA](https://github.com/twall/jna) licensed under LGPL.

