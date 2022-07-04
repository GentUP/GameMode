# GameMode

Allows assigning per-gamemode permissions (e.g. only give your mods access to survival and spectator)

## Commands

Everything is as in vanilla, except for these things:
* `/gm` is a shorthand to `/gamemode`
* Numeric gamemode codes `(0, 1, 2, 3)` are supported alongside full gamemode names.

## Permissions

Permissions go as follows:


| Permission node      | Description                 |
| -------------------- | --------------------------- |
gamemode.use           | Access to the actual command|
gamemode.*             | Access to all gamemodes     |
gamemode.survival      | Access to survival          |
gamemode.creative      | Access to creative          |
gamemode.adventure     | Access to adventure         |
gamemode.spectator     | Access to spectator         |

## Compiling

Run `mvn clean package` and locate to the `target` folder.

***
P.S. I know this code is not that good, I'll improve it, I swear!!1!