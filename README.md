# MultiMaker mod for Minecraft Forge

## About
Updated for Minecraft 1.10.2! This mod has been updated and tested with Minecraft Forge forge-1.10.2-12.18.1.2011.

This is an educational mod for use in Java coding lessons, designed to show how a complex mod with multiple custom elements work. Although the code usually builds and runs fine in single player, it's still very experimental and might not work in your environment.

## Prerequisites
You will need:
* Java JDK (this was made using Oracle JDK SE 8)
* Minecraft Forge MDK __source code.__ Don't get just the installer, you need the source tree! http://files.minecraftforge.net/

Highly recommended:
* An IDE (integrated development environment) that plays well with Forge. Eclipse and IntelliJ IDEA work well.

Set up the workspace according to the instructions at [the official Forge wiki.] (http://www.minecraftforge.net/wiki/Installation/Source)

## How to use

For now, download the repo as a ZIP file (or clone it) and copy the contents of `src` into the `src` folder of your Forge source tree. I recommend that you have your decompiled workspace `(gradlew setupDecompWorkspace)` already set up before you copy the files, but Gradle has run without a hitch even after replacing the src folder.

## Bugfixes, pull requests, etc.

As this is an experimental project, I'm not accepting patches or pull requests at this time. Those brave souls who wish to use this mod as a base for their mods are more than welcome to fork it (see License below).

## Changelog

Changes from the mod for 1.8.9:

- Removed all packages, resource folders, and mods named "makersville" to FINALLY eliminate rendering bugs caused by laziness. Old mod code moved to a "misc" subpackage under multimaker.
- Updated rendering helper class to use 1.9+ code and removed its dependency on the mod ID.
- Updated all Item and Block initialization code to use 1.9+ requirements (primarily, registry names instead of unlocalized names).
- Updated en_US.lang to use the generated unlocalized names.
- Added Combustible Lemons: Monkey-patched an issue where the initial velocity for thrown Combustible Lemons was zero.
- Added Lemonade.

## License

The MIT License (MIT)

Copyright (c) 2015 Morio Murase and Makersville

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
