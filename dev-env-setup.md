# CIMTool Development Environment Setup

## Part 1:  Eclipse Installation

> A special edition of the Eclipse development environment is required to develop CIMTool.  This environment is known as the [Eclipse for RCP and RAP Developers](https://www.eclipse.org/downloads/packages/release/indigo/sr2/eclipse-rcp-and-rap-developers) package (the newer 4.x PDE package is referred to as the Eclipse Committers package).  Since CIMTool is currently built on the older Eclipse 3.x SWT plug-ins platform this older version is required.  The following steps describe how to locate, install and setup this package:

###### Step 1:
The Windows 64-bit version of Eclipse PDE 3.7.2 (Indigo) can be downloaded at [eclipse-rcp-indigo-SR2-win32-x86_64.zip](https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/indigo/SR2/eclipse-rcp-indigo-SR2-win32-x86_64.zip). (Note that versions for Mac and Linux are also available at [Eclipse for RCP and RAP Developers](https://www.eclipse.org/downloads/packages/release/indigo/sr2/eclipse-rcp-and-rap-developers) but the instructions that follow are for Windows only.)

###### Step 2:
Though the CIMTool plug-ins themselves are configured and compiled for a later version of Java the Eclipse PDE 3.7.2 (Indigo) development environment itself requires Java 1.5.  If you do not have this older version of the JRE or JDK on your system you should locate and install it before moving on to the next step.  Currently, [Oracle's Java Archives](https://www.oracle.com/java/technologies/oracle-java-archive-downloads.html) page links to the [Java Development Kit 5.0 Update 22](https://www.oracle.com/java/technologies/java-archive-javase5-downloads.html#license-lightbox) Windows 64-bit release (i.e. the ```jdk-1_5_0_22-windows-amd64.exe``` installer). Note that you will need to accept Oracle's license agreement and have a (free) Oracle account to do so.  Feel free to locate and install Java from an alternate provider if desired.


###### Step 3:
The installation process for the Eclipse environment is straightforward in that it involves simply extracting the [eclipse-rcp-indigo-SR2-win32-x86_64.zip](https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/indigo/SR2/eclipse-rcp-indigo-SR2-win32-x86_64.zip) archive downloaded in step 1.  It should be noted that depending on where you choose to extract the archive that on Windows the process may fail due to path names being too long.  If this occurs it is suggested you create a temp directory off of the root of one of your local drives (e.g. ```C:\temp-indigo```) and extract the ZIP archive into that folder.  The shorter base path should prevent "path too long" errors while extracting the archive.  A folder called ```\eclipse``` will be created under the selected extract directory and will contain your eclipse environment.  Feel free to relocate this new folder to a location on the file system where you prefer to host your Eclipse plug-ins development environment.

Presume that for this working example the default JRE/JDK on the Windows system is a newer version of Java (e.g. Java 11). If an attempt is made to launch the development environment directly via the ```eclipse.exe``` executable the system default JRE/JDK is used and a dialog similar to the following will be displayed:

  <img src="/assets/img/install-java-error-0.png"  border="1px" style="max-width:100%"/>


At this stage creating a shortcut to the ```eclipse.exe``` that explicitly specifies the JRE/JDK to be used will resolve the issue:  

 * Create the shortcut by performing a right mouse click on the ```eclipse.exe``` executable and selecting ```Create shortcut```:

 <img src="/assets/img/install-eclipse-shortcut-0.png"  border="1px" style="max-width:75%"/>


 * Next, right mouse click on the new shortcut and select ```Properties```.  In the **Target** text field shown below specify a launch configuration consistent with your system's installation.  The field below (though not fully visible) contains an example launch configuration illustrating the use of the ```-vm``` option to specify the JRE/JDK Eclipse should use at startup:
 ```
 C:\eclipse-committers-3.7.2\eclipse.exe -vm "C:\Program Files\Java\jdk1.5.0_22\bin\javaw.exe"
 ```

 <img src="/assets/img/install-eclipse-shortcut-1.png"  border="1px" style="max-width:100%"/>

## Part 2:  Install Additional Plugin Dependencies

> There are two additional plugin dependencies needed by CIMTool that are not pre-packaged with this packaged instance of the Eclipse 3.7.2 Plugin Development Environment.  These dependencies must be installed prior to importing the CIMTool project in Part 3 of these instructions.

### Installation of the Eclipse EMF 2.6.0 (org.eclipse.emf) Plugin

The installation of this plugin is performed manually using the steps as outlined. Be sure that your instance of Eclipse is **shut down** before performing the installation.

###### Step 1:
Download the [Eclipse EMF (Core) 2.6.0 Plugin](https://github.com/CIMug-org/CIMTool/blob/gh-pages/assets/archives/org.eclipse.emf_2.6.0.v20110606-0949.jar) and temporarily copy it to a local directory.


###### Step 2:
Locate the ```\dropins``` directory as illustrated in the screenshot below and drop the plugin jar into it.

<img src="/assets/img/install-plugins-dropins-folder.png"  border="1px" style="max-width:100%"/></a>

###### Step 3:
Last, launch Eclipse and verify that the plug-in was properly installed.  It should appear within the Plug-ins tab as shown.

<img src="/assets/img/confirm-emf-2.6.0-plugin-installed.png"  border="1px" style="max-width:100%"/></a>

### Installation of the ScalaIDE 3.0.0 Plugin

An older version of the Scala-IDE plugin (located at the [ScalaIDE for Eclipse Archive site](http://scala-ide.org/download/prev-stable.html)). The installation steps are:

###### Step 1:
Download the [update-site.zip](http://download.scala-ide.org/sdk/helium/e37/scala29/stable/update-site.zip) file and extract it to a local directory on your file system.  The directory structure after extraction should look like:


    |
    site (root directory)
        |
        features (directory containing the scala-ide features .jar files)
        |
        plugins (directory containing the scala-ide plug-ins .jar files)
        |
        artifacts.jar
        content.jar (this is the archive file that will be selected in a later step)


###### Step 2:
Next launch Eclipse and select the "**Install New Software...**" menu option as shown in the screenshot.

<img src="/assets/img/install-scala-ide-plugin-0.png"  border="1px" style="max-width:100%"/></a>

###### Step 3:
In the **Install** wizard dialog that is launched click "**Add...**" to launch the **Add Repository** dialog.

<img src="/assets/img/install-scala-ide-plugin-1.png"  border="1px" style="max-width:100%"/></a>

###### Step 4:
In the **Add Repository** dialog click "**Local...**" button:

<img src="/assets/img/install-scala-ide-plugin-2a.png"  border="1px" style="max-width:100%"/></a>

Using the file chooser navigate to the location  where the [update-site.zip](http://download.scala-ide.org/sdk/helium/e37/scala29/stable/update-site.zip) archive was extracted to and select the ```\site``` directory and click "**OK**".

<img src="/assets/img/install-scala-ide-plugin-2b.png"  border="1px" style="max-width:100%"/></a>

Finally, enter a name for this new local plugin repository in the **Name** field.  Note that the **Location** field should now reference the ```\site``` directory you just selected (i.e. the "root" of the file structure described in **step 1**):

<img src="/assets/img/install-scala-ide-plugin-2c.png"  border="1px" style="max-width:100%"/></a>

###### Step 5:
Next, select the check boxes as shown in the **details** sections of the screen shot below.  Once selected click the "**Select All**" button and then "**Next**" to proceed to the next page of the installation wizard.

<img src="/assets/img/install-scala-ide-plugin-3.png"  border="1px" style="max-width:100%"/></a>

###### Step 6:
Continue by clicking "**Next**" to accept the items to be installed.

<img src="/assets/img/install-scala-ide-plugin-4.png"  border="1px" style="max-width:100%"/></a>

###### Step 7:
On the **Review Licenses** page select the "I accept the terms of the license agreements" radio button and click the "**Finish**" button.

<img src="/assets/img/install-scala-ide-plugin-5.png"  border="1px" style="max-width:100%"/></a>

###### Step 8:
A security warning will be displayed.  Just click "**OK**" to continue.

<img src="/assets/img/install-scala-ide-plugin-6.png"  border="1px" style="max-width:100%"/></a>

###### Step 9:
If all was successful a final dialog is displayed asking if you want to restart in order for the plug-ins to take affect.  Click the "**Restart Now**" button and allow your instance of Eclipse to restart.

<img src="/assets/img/install-scala-ide-plugin-7.png"  border="1px" style="max-width:100%"/></a>

## Part 3:  Clone and Import of the CIMTool Project  

> The final steps needed to complete the setup of the CIMTool Eclipse Development Environment is to clone an appropriate development branch of the CIMTool codebase from the [CIMTool GitHub Repo](https://github.com/CIMug-org/CIMTool).  There are two general approaches to clone a branch for use in Eclipse with the second being the one outlined in the steps that follow:
- Utilizing external tooling such as GitHub Desktop, TortoiseGit, Git Bash, Git GUI, etc. a clone is performed to a local directory.  In this scenario the projects in that directory are subsequently imported into an  workspace.
- Alternatively, Eclipse's pre-bundled **EGit** plugin can be used to directly clone and automatically import the CIMTool projects in Eclipse.

##### Cloning a CIMTool Branch Using the Eclipse EGit Plugin

###### Step 1:

Start out by opening the EGit Perspective in Eclipse as shown in the next two screenshots.

Presume that for this working example the default JRE/JDK on the Windows system is a newer version of Java (e.g. Java 11). If an attempt is made to launch the development environment directly via the ```eclipse.exe``` executable the system default JRE/JDK is used and a dialog similar to the following will be displayed:

<img src="/assets/img/egit-clone-repo-1.png"  border="1px" style="max-width:75%"/>

Then select the **"Git Repository Exploring"** Perspective...

<img src="/assets/img/egit-clone-repo-2.png"  border="1px" style="max-width:50%"/>

###### Step 2:

Next select the **"Clone a Git repository"** option as shown.

<img src="/assets/img/egit-clone-repo-3.png"  border="1px" style="max-width:100%"/>

###### Step 3:
Depending on your local Git installation you may or may not be shown the **"Check Home Directory"** dialog.  If this dialog appears you may choose to either update the HOME environment variable and return to the previous **Step 2** or you can simply click the OK button and accept the default Git repository location.

<img src="/assets/img/egit-clone-repo-4.png"  border="1px" style="max-width:100%"/>

###### Step 4:
Next, navigate back to the CIMug-org GitHub Open Source Site and copy the URL of the CIMTool repository to the clipboard as shown in the screenshot below.  Note that this will be used in the **"Clone Git Repository"** dialog.

<img src="/assets/img/egit-clone-repo-5.png"  border="1px" style="max-width:100%"/>

###### Step 5:
Paste the copied URL into the **URI** field as shown next.  Doing so will then auto-populate the **Host** and **Repository Path** fields on the wizard page.  At this point you must select the **Protocol** which can be either ```https``` or ```git``` depending on preference. Then click the **Next** button.

<img src="/assets/img/egit-clone-repo-6.png"  border="1px" style="max-width:75%"/>

###### Step 6:
The next page of the **"Clone Git Repository** dialog wizard will be displayed asking for you to select the branches to clone from the remote repository.  You can choose to select any number or even all branches that you may be interested in and click **Next**.  Note in this example screenshot all are selected but that commonly is not necessary.

<img src="/assets/img/egit-clone-repo-7.png"  border="1px" style="max-width:75%"/>

###### Step 7:
On the final page of the dialog wizard you should select from the **Initial branch** drop down the specific branch you want to clone.  In this example the "release-1.10.0.RC2" branch has been selected.  Note that the branch can be changed later to one of the other branches that was included in the checked list but for now choose .   

Finally, be sure on this wizard page to check the **"Import all existing projects after clone finishes"** and click the **"Finish"** button.

<img src="/assets/img/egit-clone-repo-8.png"  border="1px" style="max-width:100%"/>


###### Step 8:
Upon completion of the cloning and import projects process switch to the **"Plug-in Development"** perspective.  If there are no errors/problems to address then the Projects listed should appear similar to the next screenshot and the "Problems" tab indicate no errors.  However, if errors/problems do exist as illustrated in the second screenshot then continue on with **Step 9** and onward of this cloning procedure.

- Successful import
<img src="/assets/img/egit-clone-repo-14.png"  border="1px" style="max-width:100%"/>

- Import with errors
<img src="/assets/img/egit-clone-repo-9.png"  border="1px" style="max-width:100%"/>


###### Step 9:
A common error upon auto-import of the projects is the lack of a JDK matching that of the projects (currently a JDK level of 1.6 is needed).  A proper JDK/JRE must be added to the listed of **"Installed JREs"** if the required one is not present.  Once installed most of the errors will be resolved after performing a "clean all projects" in Eclipse. Note that in the example screenshot only a JDK 1.5.x is installed and the steps that follow show how a JDK is select from those installed on a local file system.

- First, from the Eclipse **"Preferences"** dialog select the **Add** button.

  <img src="/assets/img/egit-clone-repo-10.png"  border="1px" style="max-width:100%"/>

- Next, select the **"Standard VM"** JRE Types and click the **"Next"** button.

  <img src="/assets/img/egit-clone-repo-11.png"  border="1px" style="max-width:100%"/>

- Next, select the **"Directory..."** button and choose a JRE home directory on the file system corresponding to the version of the JRE desired.  Note that once selected the other fields in the dialog will auto-populate.  Just click the **"Finish"** button to add the JRE.  Once finished execute a "Clean all projects" from within Eclipse.

  <img src="/assets/img/egit-clone-repo-12.png"  border="1px" style="max-width:100%"/>

- At this stage either all errors will have been removed from the projects.  However, depending on whether cloning to a new workspace or not a final set of error related to the Scala libraries may be present as shown in the next screenshot.  If that is the case then perform **Step 10** to resolve any Scala-related errors.

  <img src="/assets/img/egit-clone-repo-13.png"  border="1px" style="max-width:100%"/>


###### Step 10:
Scala-related errors at this stage usually indicate that the steps outlined earlier under the **Installation of the ScalaIDE 3.0.0 Plugin** section in the **"Part 2: Install Additional Plugin Dependencies"** of these instructions either may not have been applied yet or may need to be performed once again if the earlier steps were not accurately followed.  

Once the steps have been applied the final result should appear as in this final screenshot.

<img src="/assets/img/egit-clone-repo-14.png"  border="1px" style="max-width:100%"/>