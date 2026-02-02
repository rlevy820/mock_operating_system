
# DesktopV2 - Java Desktop Environment

A mock desktop operating system mimicking retro Apple OS with a document editor, drawing tool, and calculator.

## Features

### Desktop Environment
- **Home Desktop**: Clean, intuitive desktop interface with menu-based navigation
- **Folder Management**: Create and organize folders through the File menu
- **Application Launcher**: Easy access to integrated applications via the Apps menu
- **Document Loading**: Load and manage saved documents and files

### Integrated Applications

#### Documents App
- **Text Editor**: Full-featured document editor with title and content areas
- **Save & Load**: Persistent document storage and retrieval
- **Folder Integration**: Documents integrate seamlessly with the desktop folder system
- **Read-Only Mode**: View saved documents in protected mode

#### Draw App
- **Freehand Drawing**: Mouse-controlled drawing with smooth polylines
- **Color Options**: Choose between Red, Blue, and Black colors
- **Brush Sizes**: Three brush sizes - Small (1px), Medium (3px), Large (6px)
- **Real-time Drawing**: Immediate visual feedback while drawing

#### Calculator App
- **GUI Calculator**: Button-based calculator interface
- **Standard Operations**: Basic arithmetic operations (in development)

### Using Applications

#### Documents App

1. __New Document__: Apps → Documents
2. __Write Content__: Enter title in top field, content in main text area
3. __Save Document__: File → Save & Quit
4. __Open Document__: File → Open → Load, then click on document name

#### Draw App

1. __Launch Drawing__: Apps → Draw
2. __Change Colors__: Color menu → Red/Blue/Black
3. __Change Brush Size__: Size menu → Small/Medium/Large
4. __Draw__: Click and drag mouse to draw
5. __Save Drawing__: File → Save & Quit

#### Calculator App

1. __Launch Calculator__: Apps → Calculator (currently in development)

## Technical Details

### Architecture

- __Object-Oriented Design__: Each application is a separate class extending JFrame
- __Event-Driven__: Uses ActionListener interface for menu interactions
- __Swing Components__: Built entirely with Java Swing for cross-platform compatibility
- __Data Management__: ArrayList-based storage for folders and documents

### Key Components

- __Home.java__: Central desktop manager handling navigation and app launching
- __Application Classes__: Independent window applications that integrate with the desktop
- __Polyline Drawing__: Smooth drawing implementation using coordinate arrays
