USE [master]
GO
/****** Object:  Database [servicioBiblioteca]    Script Date: 14/04/2021 12:01:52 a. m. ******/
CREATE DATABASE [servicioBiblioteca]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'servicioBiblioteca', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\servicioBiblioteca.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'servicioBiblioteca_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\servicioBiblioteca_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [servicioBiblioteca] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [servicioBiblioteca].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [servicioBiblioteca] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [servicioBiblioteca] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [servicioBiblioteca] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [servicioBiblioteca] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [servicioBiblioteca] SET ARITHABORT OFF 
GO
ALTER DATABASE [servicioBiblioteca] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [servicioBiblioteca] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [servicioBiblioteca] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [servicioBiblioteca] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [servicioBiblioteca] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [servicioBiblioteca] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [servicioBiblioteca] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [servicioBiblioteca] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [servicioBiblioteca] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [servicioBiblioteca] SET  DISABLE_BROKER 
GO
ALTER DATABASE [servicioBiblioteca] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [servicioBiblioteca] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [servicioBiblioteca] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [servicioBiblioteca] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [servicioBiblioteca] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [servicioBiblioteca] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [servicioBiblioteca] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [servicioBiblioteca] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [servicioBiblioteca] SET  MULTI_USER 
GO
ALTER DATABASE [servicioBiblioteca] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [servicioBiblioteca] SET DB_CHAINING OFF 
GO
ALTER DATABASE [servicioBiblioteca] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [servicioBiblioteca] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [servicioBiblioteca] SET DELAYED_DURABILITY = DISABLED 
GO
USE [servicioBiblioteca]
GO
/****** Object:  Table [dbo].[Ejemplar]    Script Date: 14/04/2021 12:01:52 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Ejemplar](
	[ejemplarID] [int] NOT NULL,
	[nombre] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Ejemplar] PRIMARY KEY CLUSTERED 
(
	[ejemplarID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Genero]    Script Date: 14/04/2021 12:01:52 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Genero](
	[genero] [varchar](45) NOT NULL,
 CONSTRAINT [PK_Genero] PRIMARY KEY CLUSTERED 
(
	[genero] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Libro]    Script Date: 14/04/2021 12:01:52 a. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Libro](
	[nombre] [varchar](50) NOT NULL,
	[descripcion] [varchar](150) NULL,
	[autor] [varchar](50) NOT NULL,
	[genero] [varchar](45) NOT NULL,
 CONSTRAINT [PK_Libro] PRIMARY KEY CLUSTERED 
(
	[nombre] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[Ejemplar]  WITH CHECK ADD  CONSTRAINT [FK_Ejemplar_Libro] FOREIGN KEY([nombre])
REFERENCES [dbo].[Libro] ([nombre])
GO
ALTER TABLE [dbo].[Ejemplar] CHECK CONSTRAINT [FK_Ejemplar_Libro]
GO
ALTER TABLE [dbo].[Libro]  WITH CHECK ADD  CONSTRAINT [FK_Libro_Genero] FOREIGN KEY([genero])
REFERENCES [dbo].[Genero] ([genero])
GO
ALTER TABLE [dbo].[Libro] CHECK CONSTRAINT [FK_Libro_Genero]
GO
USE [master]
GO
ALTER DATABASE [servicioBiblioteca] SET  READ_WRITE 
GO
